package com.linkedList;

import java.util.Arrays;

interface LinkedList<T> {

    void insertHead(T value);

    void append(T value);

    void insert(T value, int index);

    void remove(T value);

    int indexOf(T value);

    void print();

    T get(int index);

    T[] toArray();
}
