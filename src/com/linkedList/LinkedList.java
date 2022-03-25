package com.linkedList;

interface LinkedList<T> {

    void insertHead(T value);

    void append(T value);

    void insert(T value, int index);

    boolean remove(T value);

    int indexOf(T value);

    void print();

    T get(int index);

    Object[] toArray();
}
