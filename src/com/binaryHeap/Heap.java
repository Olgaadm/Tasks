package com.binaryHeap;

public interface Heap {
    void insert(int value);

    int min();

    boolean extractMin();
}
