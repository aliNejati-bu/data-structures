package com.ali.linkedLists;

import com.ali.linkedLists.abstraction.ILinkedList;
import com.ali.utils.Node;

public class LinkedList<E> implements ILinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    private Node<E> headOfIterate;
    boolean inIter = false;
    @Override
    public E getHeadData() {
        return this.getHead().data;
    }

    @Override
    public E getTailData() {
        return this.getTail().data;
    }

    @Override
    public int getSize() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    private void setTail(Node<E> tail) {
        this.tail = tail;
    }

    private void setHead(Node<E> head) {
        this.head = head;
    }

    @Override
    public LinkedList<E> addFirst(E data) {
        Node<E> node = new Node<E>(null, null, data);
        if (size == 0) {
            setHead(node);
            setTail(node);
            size++;
            return this;
        }
        node.next = this.getHead();
        getHead().prev = node;
        setHead(node);
        size++;
        return this;
    }

    @Override
    public LinkedList<E> addLast(E data) {
        Node<E> node = new Node<E>(null, null, data);
        if (size == 0) {
            setHead(node);
            setTail(node);
            size++;
            return this;
        }
        node.prev = getTail();
        getTail().next = node;
        setTail(node);
        size++;
        return this;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            return null;
        }
        if (size == 0) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        Node<E> c = getHead();
        int counter = 0;
        while (c != null) {
            if (index == counter) {
                return c.data;
            }
            counter++;
            c = c.next;
        }
        return null;
    }

    @Override
    public E deleteTail() {
        if (size == 0) {
            return null;
        }
        E data = getTail().data;
        if (getTail().prev == null) {
            size = 0;
            setHead(null);
            setTail(null);
            return data;
        }
        setTail(getTail().prev);
        getTail().next = null;
        size--;
        return data;
    }

    @Override
    public ILinkedList<E> buildNew() {
        return new LinkedList<E>();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> c = getHead();
        while (c != null) {
            result.append(c.toString()).append(",");
            c = c.next;
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public E deleteHead() {
        if (size == 0) {
            return null;
        }
        E data = getHead().data;
        if (getHead().next == null) {
            size = 0;
            setHead(null);
            setTail(null);
            return data;
        }
        setHead(getHead().next);
        getHead().prev = null;
        size--;
        return data;
    }



    @Override
    public boolean hasNext() {
        if (getSize() == 0){
            return false;
        }
        if (!inIter){
            headOfIterate = getHead();
            inIter = true;
        }

        if (headOfIterate == null){
            inIter = false;
            return false;
        }

        return true;

    }

    @Override
    public E next() {
        E data = headOfIterate.data;
        headOfIterate = headOfIterate.next;
        return data;
    }
}
