package com.ali.trees.binaryTree.abstraction;

import com.ali.linkedLists.abstraction.ILinkedList;
import com.ali.trees.binaryTree.Node;

public interface IBinaryTree<E> {
    public IBinaryTree insert(Node<E> newNode);
}
