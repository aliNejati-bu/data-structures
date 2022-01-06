package com.ali.utils;

public class Node<E> {
    public Node<E> next = null;
    public Node<E> prev = null;
    public E data;


    public Node(Node<E> next, Node<E> prev, E data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
