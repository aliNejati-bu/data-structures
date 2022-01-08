package com.ali.queues;

import com.ali.queues.abstraction.IQueue;

public class LinearQueue<E> implements IQueue<E> {
    int size,front = -1,rear=-1;
    E[] items;
    public LinearQueue(int size) {
        items = (E[]) new Object[size];
        this.size = size;
    }

    @Override
    public boolean enQueue(E data) {
        if (rear == size - 1)
            return false;
        items[++rear] = data;
        return true;
    }

    @Override
    public E deQueue() {
        if (front == rear){
            return null;
        }
        return items[++front];
    }
}
