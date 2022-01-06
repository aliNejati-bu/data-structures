package com.ali.linkedLists;

import com.ali.utils.Node;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

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

    public E get(int index){
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
            if (index == counter){
                return c.data;
            }
            counter++;
            c = c.next;
        }
        return null;
    }

    public E deleteTail(){
        if (size == 0){
            return null;
        }
        E data = getTail().data;
        setTail(getTail().prev);
        getTail().next = null;
        size--;
        return data;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> c = getHead();
        while (c != null){
            result.append(c.toString()).append(",");
            c = c.next;
        }
        result.append("]");
        return result.toString();
    }

    public E deleteHead(){
        if (size == 0){
            return null;
        }
        E data = getHead().data;
        setHead(getHead().next);
        getHead().prev = null;
        size --;
        return data;
    }

}
