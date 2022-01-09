package com.ali.trees.binaryTree;

public class Node<E> {
    private Node<E> left;
    private E data;
    private Node<E> right;
    public boolean leftThread = false;
    public boolean rightThread = false;
    @Override
    public String toString() {
        if (right != null && left != null) {
            return data + "{" +
                    left +
                    "," +
                    right +
                    '}';
        }else if (right != null && left == null){
            return data + "{null , " +
                    right +
                    '}';
        }else if (right == null && left != null){
            return data + "{" +
                    left +
                    " , null }";
        }
        return data.toString();
    }

    public Node(Node<E> left, E data, Node<E> right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getLeft() {
        return left;
    }

    public E getData() {
        return data;
    }

    public Node<E> getRight() {
        return right;
    }

}
