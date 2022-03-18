package com.linkedList.tests;

import com.linkedList.DoublyLinkedList;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class DoublyLinkedListTest {


    @Test
    void insertValueToHead() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertHead(4);
        doublyLinkedList.insert(5, 0);
        doublyLinkedList.insertHead(79);
        Integer[] expectedArray = {79, 5, 4};
        Assert.assertEquals(doublyLinkedList.toArray(), expectedArray);
    }

    @Test
    void appendAndInsertValue() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.append(22);
        doublyLinkedList.insert(5, 0);
        doublyLinkedList.append(79);
        doublyLinkedList.insert(10, 2);

        Integer[] expectedArray = {5, 22, 10, 79};
        Assert.assertEquals(doublyLinkedList.toArray(), expectedArray);
    }

    @Test
    void appendValue() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.append(22);
        doublyLinkedList.append(505);
        doublyLinkedList.append(24);
        doublyLinkedList.append(12);

        Integer[] expectedArray = {22, 505, 24, 12};
        Assert.assertEquals(doublyLinkedList.toArray(), expectedArray);
    }

    @Test
    void insertValueDifferentIndexes() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.insert(400, 1);
        doublyLinkedList.insert(77, 1);
        doublyLinkedList.insert(4, 2);
        doublyLinkedList.insert(90, 3);
        doublyLinkedList.insert(107, 4);
        doublyLinkedList.insert(96, 6);

        Integer[] expectedArray = {505, 77, 4, 90, 107, 400, 96, 22};
        Assert.assertEquals(doublyLinkedList.toArray(), expectedArray);
    }

    @Test
    void insertValueIncorrectIndex() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.insert(400, 1);
        try {
            doublyLinkedList.insert(77, 9);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not available");
        }
        try {
            doublyLinkedList.insert(77, -1);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not available");
        }
    }

    @Test
    void insertValueNegativeIndex() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.insert(400, 1);
        try {
            doublyLinkedList.insert(77, -1);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not available");
        }
    }

    @Test
    void checkIndexOfElements() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.insert(400, 1);
        doublyLinkedList.insert(77, 1);
        Assert.assertEquals(doublyLinkedList.indexOf(22), 3);
        Assert.assertEquals(doublyLinkedList.indexOf(505), 0);
        Assert.assertEquals(doublyLinkedList.indexOf(400), 2);
        Assert.assertEquals(doublyLinkedList.indexOf(77), 1);
    }

    @Test
    void checkIndexOfUnexcitedElements() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.insert(400, 1);
        doublyLinkedList.insert(77, 1);
        Assert.assertEquals(doublyLinkedList.indexOf(23), -1);
        Assert.assertEquals(doublyLinkedList.indexOf(33), -1);
        Assert.assertEquals(doublyLinkedList.indexOf(401), -1);
        Assert.assertEquals(doublyLinkedList.indexOf(78), -1);
    }

    @Test
    void removeElementsFromList() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.append(8);
        doublyLinkedList.insert(400, 1);
        doublyLinkedList.insert(77, 1);
        doublyLinkedList.insert(9, 1);
        doublyLinkedList.remove(505);
        doublyLinkedList.remove(9);
        doublyLinkedList.append(4);
        doublyLinkedList.remove(22);
        doublyLinkedList.remove(4);


        Integer[] expectedArrayAfterRemoval = {77, 400, 8};
        Assert.assertEquals(doublyLinkedList.toArray(), expectedArrayAfterRemoval);
    }

    @Test
    void removeUnexcitedElementFromList() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.insert(9, 1);
        try {
            doublyLinkedList.remove(4);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "There is no such element in list");
        }
    }

    @Test
    void removeElementFromEmptyList() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        try {
            doublyLinkedList.remove(4);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "There are no elements in list yet");
        }
    }

    @Test
    void getElementByIndex() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);
        doublyLinkedList.insert(505, 0);
        doublyLinkedList.append(8);
        doublyLinkedList.insert(400, 1);
        doublyLinkedList.insert(77, 1);
        doublyLinkedList.insert(9, 4);

        Assert.assertEquals(doublyLinkedList.get(0), Integer.valueOf(505));
        Assert.assertEquals(doublyLinkedList.get(1), Integer.valueOf(77));
        Assert.assertEquals(doublyLinkedList.get(2), Integer.valueOf(400));
        Assert.assertEquals(doublyLinkedList.get(3), Integer.valueOf(22));
        Assert.assertEquals(doublyLinkedList.get(4), Integer.valueOf(9));
        Assert.assertEquals(doublyLinkedList.get(5), Integer.valueOf(8));
    }

    @Test
    void getElementByIncorrectIndex() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insert(22, 0);

        try {
            Assert.assertEquals(doublyLinkedList.get(8), Integer.valueOf(505));
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not correct or list is empty");
        }
        try {
            Assert.assertEquals(doublyLinkedList.get(-1), Integer.valueOf(77));
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not correct or list is empty");
        }
    }
}
