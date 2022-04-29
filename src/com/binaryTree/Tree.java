package com.binaryTree;

public interface Tree {

    boolean insert(int value);

    boolean delete(int value);

    boolean contains(int value);

    void inorder();
}
