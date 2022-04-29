package com.binaryHeap.tests;

import com.binaryHeap.BinaryHeap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinaryHeapTest {

    @Test
    public void testInsert() {
        BinaryHeap binaryHeap = new BinaryHeap(13);
        binaryHeap.insert(8);
        binaryHeap.insert(2);
        binaryHeap.insert(100);
        binaryHeap.insert(5);
        binaryHeap.insert(600);
        binaryHeap.insert(23);
        binaryHeap.insert(54);
        binaryHeap.insert(23);
        binaryHeap.insert(66);
        binaryHeap.insert(7);
        binaryHeap.insert(8);

        binaryHeap.print();

    }

    @Test
    public void testMin() {
        BinaryHeap binaryHeap = new BinaryHeap(13);
        binaryHeap.insert(8);
        binaryHeap.insert(2);
        binaryHeap.insert(100);
        binaryHeap.insert(5);
        binaryHeap.insert(600);
        binaryHeap.insert(23);
        binaryHeap.insert(54);
        binaryHeap.insert(23);
        binaryHeap.insert(66);
        binaryHeap.insert(7);
        binaryHeap.insert(8);
        Assert.assertEquals(binaryHeap.min(), 2);

    }

    @Test
    public void testExtractMin() {
        BinaryHeap binaryHeap = new BinaryHeap(13);
        binaryHeap.insert(8);
        binaryHeap.insert(2);
        binaryHeap.insert(100);
        binaryHeap.insert(5);
        binaryHeap.insert(600);
        binaryHeap.insert(23);
        binaryHeap.insert(54);
        binaryHeap.insert(23);
        binaryHeap.insert(66);
        binaryHeap.insert(7);
        binaryHeap.insert(8);

        binaryHeap.extractMin();
        binaryHeap.extractMin();
        binaryHeap.print();
    }
}