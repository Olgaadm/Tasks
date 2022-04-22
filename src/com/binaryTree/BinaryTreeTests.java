package com.binaryTree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryTreeTests {

    @Test
    public void testInsert() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(100);
        binaryTree.insert(5);
        binaryTree.insert(600);
        binaryTree.insert(23);
        binaryTree.insert(54);
        binaryTree.insert(23);
        binaryTree.insert(66);
        binaryTree.insert(7);
        binaryTree.insert(8);

        binaryTree.inorder();

    }

    @Test
    public void testDelete() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(100);
        binaryTree.insert(5);
        binaryTree.insert(600);
        binaryTree.insert(23);
        binaryTree.insert(54);
        binaryTree.insert(23);
        binaryTree.insert(66);
        binaryTree.insert(7);
        binaryTree.insert(8);

        binaryTree.delete(7);
        binaryTree.delete(54);
        binaryTree.delete(600);

        binaryTree.delete(8);
        binaryTree.inorder();

    }

    @Test
    public void testContains() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(100);
        binaryTree.insert(5);
        binaryTree.insert(600);
        binaryTree.insert(23);
        binaryTree.insert(54);
        binaryTree.insert(23);
        binaryTree.insert(66);
        binaryTree.insert(7);
        binaryTree.insert(8);

        binaryTree.delete(8);
        binaryTree.delete(23);
        binaryTree.delete(600);
        binaryTree.delete(5);
        binaryTree.inorder();

        Assert.assertTrue(binaryTree.contains(100));
        Assert.assertTrue(binaryTree.contains(2));
        Assert.assertTrue(binaryTree.contains(23));
        Assert.assertFalse(binaryTree.contains(600));

    }

}