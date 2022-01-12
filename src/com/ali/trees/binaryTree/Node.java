package com.ali.trees.binaryTree;

import java.util.Objects;

public class Node<E> {
    private Node<E> left;
    private E data;
    private Node<E> right;
    private boolean leftThread = false;
    private boolean rightThread = false;

    public void setLeftThread(boolean leftThread) {
        this.leftThread = leftThread;
    }

    public void setRightThread(boolean rightThread) {
        this.rightThread = rightThread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public boolean isLeftThread() {
        return leftThread;
    }

    public boolean isRightThread() {
        return rightThread;
    }

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
