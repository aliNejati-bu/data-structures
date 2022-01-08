package com.ali.queues;

import com.ali.queues.abstraction.IQueue;

public class CircularQueue<E> implements IQueue<E> {
    int front = 0,rear = 0;
    int size;
    E[] items;
    boolean LOIP = false;
    public CircularQueue(int size) {
        this.size = size;
        items = (E[]) new Object[size];
    }

    @Override
    public boolean enQueue(E data) {
        if (front == rear && LOIP){
            return false;
        }
        rear++;
        if (rear == size){
            rear = 0;
        }
        items[rear] = data;
        LOIP = true;
        return true;
    }

    @Override
    public E deQueue() {
        if (front == rear && !LOIP){
            return null;
        }
        front++;
        if (front == size){
            front = 0;
        }
        LOIP = false;
        return items[front];
    }
}
