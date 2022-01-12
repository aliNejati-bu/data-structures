package com.ali.trees.binaryTree;

import com.ali.linkedLists.abstraction.ILinkedList;
import com.ali.trees.binaryTree.abstraction.IBinaryTree;

public class BinarySearchTree extends BinaryTree<Integer> implements IBinaryTree<Integer> {

    public BinarySearchTree(ILinkedList<Node<Integer>> linkedList) {
        super(linkedList);
    }

    @Override
    public IBinaryTree<Integer> insert(Node<Integer> newNode) {
        if (getRoot() == null){
            root = newNode;
            return this;
        }
        doInsert(getRoot(),newNode);
        return this;
    }

    void doInsert(Node<Integer> node,Node<Integer> newNode) {
        if (node.getData() > newNode.getData()){
            if (node.getLeft() == null){
                node.setLeft(newNode);
            }else {
                doInsert(node.getLeft(),newNode);
            }
        }else {
            if (node.getRight() == null){
                node.setRight(newNode);
            }else {
                doInsert(node.getRight(),newNode);
            }
        }
    }

    public Node<Integer> search(int data){
        return doSearch(getRoot(),data);
    }

    private Node<Integer> doSearch(Node<Integer> curr,int data){
        if (curr == null){
            return null;
        }

        if (curr.getData() == data){
            return curr;
        }

        if (curr.getData() > data){
            return doSearch(curr.getLeft(),data);
        }else {
            return doSearch(curr.getRight(),data);
        }

    }
}
