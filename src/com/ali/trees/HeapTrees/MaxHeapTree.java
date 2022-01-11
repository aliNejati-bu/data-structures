package com.ali.trees.HeapTrees;


import com.ali.trees.HeapTrees.abstraction.IHeapTree;


public class MaxHeapTree implements IHeapTree {

    int capacity;

    int[] items;

    int size = 1;

    public int getSize() {
        return size-1;
    }

    public MaxHeapTree(int capacity){
        this.capacity = capacity;
        items = new int[capacity];
    }

    @Override
    public IHeapTree insert(int item) {
        if (size >= capacity){
            resizeArray();
        }
        items[size] = item;
        size++;
        for (int i = size-1; i > 1 && items[i] > items[i/2]; i /= 2) {
            int temp = items[i];
            items[i] = items[i/2];
            items[i/2] = temp;
        }
        return this;
    }

    @Override
    public int PeekRoot() {
        return items[1];
    }

    @Override
    public int getRoot() {
        if (size == 1){
            return 0;
        }
        int result = items[1];
        size--;
        items[1] = items[size];
        items[size] = 0;
        int itemKey = 1;
        while (itemKey*2 <= size){
            int cur = itemKey*2;
            if (items[cur+1] > items[cur]){
                cur = cur+1;
            }
            if (items[itemKey] > items[cur]){
                break;
            }
            int temp = items[itemKey];
            items[itemKey] = items[cur];
            items[cur] = temp;
            itemKey = cur;
        }
        return result;
    }

    private void resizeArray(){
        int[] newArray = new int[capacity+(capacity/2)];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
        this.capacity = items.length;
    }

}
