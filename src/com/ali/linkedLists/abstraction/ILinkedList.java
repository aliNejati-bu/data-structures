package com.ali.linkedLists.abstraction;

import java.util.Iterator;

public interface ILinkedList<E> extends Iterator<E> {
    public E getHeadData();
    public E getTailData();
    public int getSize();
    public ILinkedList<E> addFirst(E data);
    public ILinkedList<E> addLast(E data);
    public E get(int index);
    public E deleteHead();
    public E deleteTail();
}
