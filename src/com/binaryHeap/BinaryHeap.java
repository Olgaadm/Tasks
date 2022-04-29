package com.binaryHeap;

public class BinaryHeap implements Heap {

    private final int[] heap;

    int numberOfValues;

    public BinaryHeap(int size) {
        heap = new int[size + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    @Override
    public void insert(int value) {
        if (numberOfValues >= heap.length - 1) {
            throw new IndexOutOfBoundsException("There are no spare space for new items in the heap");
        }
        numberOfValues = numberOfValues + 1;
        heap[numberOfValues] = value;
        bubbleUp(numberOfValues);
    }

    @Override
    public int min() {
        if (numberOfValues == 0)
            return -1;
        else
            return heap[1];
    }

    @Override
    public boolean extractMin() {
        if (numberOfValues == 0)
            return false;
        else {
            heap[1] = heap[numberOfValues];
            numberOfValues = numberOfValues - 1;
            bubbleDown(1);
            return true;
        }
    }
/*
    @Override
    public void decrease(int index, int difference) {
        if (index <= numberOfValues){

        }

    }*/

    private void bubbleUp(int index) {
        if (index > 1) {
            if (heap[parentIndex(index)] > heap[index]) {
                swap(index, parentIndex(index));
                bubbleUp(parentIndex(index));
            }
        }
    }

    private void bubbleDown(int index) {
        if (2 * index <= numberOfValues) {
            if (heap[index] > heap[childLeftIndex(index)]) {
                swap(index, childLeftIndex(index));
                bubbleDown(childLeftIndex(index));
            }
            if (heap[index] > heap[childRightIndex(index)]) {
                swap(index, childRightIndex(index));
                bubbleDown(childRightIndex(index));
            }
        }
    }

    private void swap(int firstPosition, int secondPosition) {
        var tmp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = tmp;
    }

    public void print() {
        for (int i = 1; i <= numberOfValues; i++){
            System.out.println(heap[i]);
        }
    }

    private int parentIndex(int i) {
        return i / 2;
    }

    private int childLeftIndex(int i) {
        return 2 * i;
    }

    private int childRightIndex(int i) {
        return 2 * i + 1;
    }

}
