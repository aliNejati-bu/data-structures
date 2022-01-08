package com.ali.queues.abstraction;

public interface IQueue<E> {
    public boolean enQueue(E data);
    public E deQueue();
}
