package com.ali.trees.binaryTree;

public class Node<E> {
    public Node<E> left;
    public E data;
    public Node<E> right;


    public Node(Node<E> left, E data, Node<E> right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }
}
