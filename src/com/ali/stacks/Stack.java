package com.ali.stacks;

import com.ali.linkedLists.abstraction.ILinkedList;
import com.ali.stacks.abstraction.IStack;

 public class Stack<E> implements IStack<E> {

    ILinkedList<E> linkedList;
    int top = 0;
    public Stack(ILinkedList<E> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public E peek() {
        if (getTop() == 0){
            return null;
        }
        return linkedList.getHeadData();
    }

    @Override
    public E pop() {
        if (getTop() == 0){
            return null;
        }
        top--;
        return linkedList.deleteHead();
    }

    @Override
    public IStack<E> push(E data) {
        linkedList.addFirst(data);
        top++;
        return this;
    }

     @Override
     public int getTop() {
         return top;
     }

     @Override
     public boolean isEmpty() {
         return this.top == 0;
     }

     @Override
     public String toString() {
         return linkedList.toString();
     }
 }
