package com.linkedList.tests;

import com.linkedList.SinglyLinkedList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SinglyLinkedListTest {


    @Test
    void insertValueToHead() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insertHead(4);
        singlyLinkedList.insert(5, 0);
        singlyLinkedList.insertHead(79);
        Integer[] expectedArray = {79, 5, 4};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArray);
    }

    @Test
    void appendAndInsertValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.append(22);
        singlyLinkedList.insert(5, 0);
        singlyLinkedList.append(79);
        singlyLinkedList.insert(10, 2);

        Integer[] expectedArray = {5, 22, 10, 79};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArray);
    }

    @Test
    void appendValue() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.append(22);
        singlyLinkedList.append(505);
        singlyLinkedList.append(24);
        singlyLinkedList.append(12);

        Integer[] expectedArray = {22, 505, 24, 12};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArray);
    }

    @Test
    void insertValueDifferentIndexes() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        singlyLinkedList.insert(4, 2);
        singlyLinkedList.insert(90, 3);
        singlyLinkedList.insert(107, 4);
        singlyLinkedList.insert(96, 6);

        Integer[] expectedArray = {505, 77, 4, 90, 107, 400, 96, 22};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArray);
    }

    @Test
    void insertValueIncorrectIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(400, 1);
        try {
            singlyLinkedList.insert(77, 9);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not available");
        }
        try {
            singlyLinkedList.insert(77, -1);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not available");
        }
    }

    @Test
    void insertValueNegativeIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(400, 1);
        try {
            singlyLinkedList.insert(77, -1);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not available");
        }
    }

    @Test
    void insertNullElementToList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.append(null);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(null, 2);
        singlyLinkedList.insert(9, 1);
        Integer[] expectedArray = {505, 9, 22};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArray);
    }

    @Test
    void checkIndexOfElements() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        Assert.assertEquals(singlyLinkedList.indexOf(22), 3);
        Assert.assertEquals(singlyLinkedList.indexOf(505), 0);
        Assert.assertEquals(singlyLinkedList.indexOf(400), 2);
        Assert.assertEquals(singlyLinkedList.indexOf(77), 1);
    }

    @Test
    void checkIndexOfUnexcitedElements() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        Assert.assertEquals(singlyLinkedList.indexOf(23), -1);
        Assert.assertEquals(singlyLinkedList.indexOf(33), -1);
        Assert.assertEquals(singlyLinkedList.indexOf(401), -1);
        Assert.assertEquals(singlyLinkedList.indexOf(78), -1);
    }

    @Test
    void removeElementsFromList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.append(8);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        singlyLinkedList.insert(9, 1);
        singlyLinkedList.remove(505);
        singlyLinkedList.remove(400);
        singlyLinkedList.append(4);
        singlyLinkedList.remove(22);
        singlyLinkedList.remove(4);

        Integer[] expectedArrayAfterRemoval = {9, 77, 8};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArrayAfterRemoval);
    }

    @Test
    void removeElementsFromEnd() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.append(8);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        singlyLinkedList.insert(9, 1);
        singlyLinkedList.remove(8);
        singlyLinkedList.remove(22);
        singlyLinkedList.append(4);
        singlyLinkedList.insert(200, 3);
        singlyLinkedList.remove(4);
        singlyLinkedList.insertHead(89);
        singlyLinkedList.append(68);

        Integer[] expectedArrayAfterRemoval = {89, 505, 9, 77, 200, 400, 68};
        Assert.assertEquals(singlyLinkedList.toArray(), expectedArrayAfterRemoval);
    }

    @Test
    void removeUnexcitedElementFromList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(9, 1);
        Assert.assertFalse(singlyLinkedList.remove(4));
    }

    @Test
    void removeNullElementFromList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.insert(9, 1);
        Assert.assertFalse(singlyLinkedList.remove(null));
    }


    @Test
    void removeElementFromOneElementList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.remove(22);
        Assert.assertNull(singlyLinkedList.toArray());
    }

    @Test
    void removeElementFromEmptyList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        try {
            singlyLinkedList.remove(4);
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "There are no elements in list yet");
        }
    }

    @Test
    void getElementByIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.append(8);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        singlyLinkedList.insert(9, 4);

        Assert.assertEquals(singlyLinkedList.get(0), Integer.valueOf(505));
        Assert.assertEquals(singlyLinkedList.get(1), Integer.valueOf(77));
        Assert.assertEquals(singlyLinkedList.get(2), Integer.valueOf(400));
        Assert.assertEquals(singlyLinkedList.get(3), Integer.valueOf(22));
        Assert.assertEquals(singlyLinkedList.get(4), Integer.valueOf(9));
        Assert.assertEquals(singlyLinkedList.get(5), Integer.valueOf(8));
    }

    @Test
    void removeElementsFromListAndGetByIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);
        singlyLinkedList.insert(505, 0);
        singlyLinkedList.append(8);
        singlyLinkedList.insert(400, 1);
        singlyLinkedList.insert(77, 1);
        singlyLinkedList.insert(9, 1);
        singlyLinkedList.remove(505);
        singlyLinkedList.remove(400);
        singlyLinkedList.append(4);
        singlyLinkedList.remove(22);
        singlyLinkedList.remove(4);

        Assert.assertEquals(singlyLinkedList.get(0), Integer.valueOf(9));
        Assert.assertEquals(singlyLinkedList.get(1), Integer.valueOf(77));
        Assert.assertEquals(singlyLinkedList.get(2), Integer.valueOf(8));
    }

    @Test
    void getElementByIncorrectIndex() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(22, 0);

        try {
            Assert.assertEquals(singlyLinkedList.get(8), Integer.valueOf(505));
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not correct or list is empty");
        }
        try {
            Assert.assertEquals(singlyLinkedList.get(-1), Integer.valueOf(77));
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals(e.getMessage(), "Index is not correct or list is empty");
        }
    }
}
