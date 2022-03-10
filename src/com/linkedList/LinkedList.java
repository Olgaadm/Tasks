package com.linkedList;

interface LinkedList<T> {

    void addFirst(T value);

    void addLast(T value);

    void add(T value, int index);

    void remove(T value);

    int indexOf(T value);

    void print();
}
