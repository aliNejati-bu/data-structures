package com.ali.stacks.abstraction;

public interface IStack<E> {
    public E peek();
    public E pop();
    public IStack<E> push(E data);
    public int getTop();
}
