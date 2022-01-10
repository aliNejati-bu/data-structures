package com.ali.trees.binaryTree;

import com.ali.linkedLists.abstraction.ILinkedList;

import java.util.ArrayList;

public class TheardedBinaryTree<E> {
    Node<E> root;

    public TheardedBinaryTree(Node<E> root) {
        this.root = root;
    }

    public Node<E> getRoot() {
        return root;
    }

    public TheardedBinaryTree<E> insert(Node<E> newNode, ILinkedList<Node<E>> linkedList) {
        if (getRoot().getLeft() == null) {
            newNode.setLeftThread(true);
            newNode.setRightThread(true);
            newNode.setRight(getRoot());
            getRoot().setLeft(newNode);
            return this;
        } else if (getRoot().getRight() == null) {
            newNode.setLeftThread(true);
            newNode.setRightThread(true);
            newNode.setLeft(getRoot());
            getRoot().setRight(newNode);
            return this;
        } else {
            linkedList.addLast(getRoot().getLeft());
            linkedList.addLast(getRoot().getRight());
            doInsert(linkedList, newNode);
        }
        return this;
    }

    void doInsert(ILinkedList<Node<E>> list, Node<E> newNode) {
        ILinkedList<Node<E>> newSiblingsNode = list.buildNew();
        for (ILinkedList<Node<E>> it = list; it.hasNext(); ) {
            Node<E> node = it.next();
            if (node.getLeft() == null || node.isLeftThread()) {
                node.setLeftThread(false);
                newNode.setLeftThread(true);
                newNode.setLeft(node.getLeft());
                newNode.setRightThread(true);
                newNode.setRight(node);
                node.setLeft(newNode);
                return;
            } else if (node.getRight() == null || node.isRightThread()) {
                node.setRightThread(false);
                newNode.setLeftThread(true);
                newNode.setLeft(node);
                newNode.setRightThread(true);
                newNode.setRight(node.getRight());
                node.setRight(newNode);
                return;
            }
            newSiblingsNode.addLast(node.getLeft());
            newSiblingsNode.addLast(node.getRight());
        }
        doInsert(newSiblingsNode, newNode);
    }


    public Node<E> inOrderNextNode(Node<E> node){
        if (node.isRightThread() || node.getRight() == null){
            return node.getRight();
        }
        Node<E> temp = node.getRight();
        if (temp.isLeftThread()){
            return node.getRight();
        }
        while (!temp.isLeftThread()){
            temp = temp.getLeft();
        }
        return temp;
    }


    public ArrayList<E> inOrder(){
        ArrayList<E> arrayList = new ArrayList<>();
        if (getRoot() == null){
            return arrayList;
        }
        if (getRoot().getRight() == null && getRoot().getLeft() == null){
            arrayList.add(getRoot().getData());
            return arrayList;
        }
        Node<E> lefter = getRoot();
        while (!lefter.isLeftThread()){
            lefter = lefter.getLeft();
        }
        Node<E> temp = lefter;
        while (!(temp.isRightThread() && temp.getRight() == null)){
            arrayList.add(temp.getData());
            temp = inOrderNextNode(temp);
        }
        arrayList.add(temp.getData());
        return arrayList;
    }
}
