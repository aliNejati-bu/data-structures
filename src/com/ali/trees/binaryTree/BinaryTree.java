package com.ali.trees.binaryTree;

import com.ali.linkedLists.abstraction.ILinkedList;
import com.ali.stacks.Stack;

import java.util.ArrayList;

public class BinaryTree<E> {
    Node<E> root;


    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public Node<E> getRoot() {
        return root;
    }

    public BinaryTree<E> insert(Node<E> newNode, ILinkedList<Node<E>> linkedList) {
        if (getRoot() == null) {
            this.root = newNode;
            return this;
        } else if (getRoot().getLeft() == null) {
            getRoot().setLeft(newNode);
            return this;
        } else if (getRoot().getRight() == null) {
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
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                return;
            } else if (node.getRight() == null) {
                node.setRight(newNode);
                return;
            }
            newSiblingsNode.addLast(node.getLeft());
            newSiblingsNode.addLast(node.getRight());
        }
        doInsert(newSiblingsNode, newNode);
    }

    public ArrayList<E> iterativePreOrder(Stack<Node<E>> stack) {
        ArrayList<E> result = new ArrayList<>();
        if (getRoot() == null) {
            return result;
        }
        stack.push(getRoot());
        while (!stack.isEmpty()) {
            Node<E> curNode = stack.pop();
            result.add(curNode.getData());
            if (curNode.getRight() != null) {
                stack.push(curNode.getRight());
            }
            if (curNode.getLeft() != null) {
                stack.push(curNode.getLeft());
            }
        }
        return result;
    }

    private ArrayList<E> preOrder(Node<E> node, ArrayList<E> arrayList) {
        arrayList.add(node.getData());
        if (node.getLeft() != null) {
            preOrder(node.getLeft(), arrayList);
        }
        if (node.getRight() != null) {
            preOrder(node.getRight(), arrayList);
        }
        return arrayList;
    }

    public ArrayList<E> preOrder() {
        if (getRoot() == null) {
            return new ArrayList<>();
        }
        return preOrder(getRoot(), new ArrayList<>());
    }

    private void swapTree(Node<E> node) {
        if (node == null) {
            return;
        }
        Node<E> helper = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(helper);
        if (node.getRight() != null) {
            swapTree(node.getRight());
        }
        if (node.getLeft() != null) {
            swapTree(node.getLeft());
        }
    }

    public BinaryTree<E> swapTree() {
        this.swapTree(this.getRoot());
        return this;
    }

    private int[] getNodesCounts(Node<E> node, int[] counts) {
        if (node == null) {
            return counts;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            counts[1]++;
            return counts;
        }
        counts[0]++;
        if (node.getLeft() != null) {
            getNodesCounts(node.getLeft(), counts);
        }
        if (node.getRight() != null) {
            getNodesCounts(node.getRight(), counts);
        }
        return counts;
    }


    public int[] getNodesCounts() {
        return getNodesCounts(getRoot(), new int[]{0, 0});
    }
}
