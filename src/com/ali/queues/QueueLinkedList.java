package com.ali.queues;

import com.ali.linkedLists.abstraction.ILinkedList;
import com.ali.queues.abstraction.IQueue;

public class QueueLinkedList<E> implements IQueue<E> {

    ILinkedList<E> linkedList;

    public QueueLinkedList(ILinkedList<E> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public boolean enQueue(E data) {
        linkedList.addLast(data);
        return true;
    }

    @Override
    public E deQueue() {
        return linkedList.deleteHead();
    }


    @Override
    public String toString() {
        return "QueueLinkedList{" +
                "linkedList=" + linkedList +
                '}';
    }
}
