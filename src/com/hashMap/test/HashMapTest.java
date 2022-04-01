package com.hashMap.test;

import com.hashMap.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class HashMapTest {

    @Test
    public void testPut() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(99, "test1");
        hashMap.put(1, "test3");
        hashMap.put(9, "test2");
        hashMap.put(98, "test9");
        Assert.assertEquals(hashMap.get(98), "test9");

        hashMap.put(2, "test8");
        hashMap.put(8, "test0");
        hashMap.put(97, "test6");
        hashMap.put(3, "test4");
        hashMap.put(98, "test0");
        hashMap.put(57, "test6");
        hashMap.put(35, "test4");
        hashMap.put(107, "test5");

        Assert.assertEquals(hashMap.get(99), "test1");
        Assert.assertEquals(hashMap.get(98), "test0");
        Assert.assertEquals(hashMap.get(57), "test6");
        Assert.assertEquals(hashMap.get(107), "test5");
        Assert.assertEquals(hashMap.get(35), "test4");
    }

    @Test
    public void testCapacity() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "test1");
        hashMap.put(2, "test3");
        hashMap.put(3, "test2");
        hashMap.put(4, "test9");
        hashMap.put(5, "test8");
        hashMap.put(6, "test0");
        hashMap.put(7, "test6");
        hashMap.put(8, "test4");
        hashMap.put(9, "test0");
        hashMap.put(10, "test6");
        hashMap.put(11, "test4");
        hashMap.put(12, "test5");
        hashMap.put(13, "test5");

        Assert.assertEquals(hashMap.getCapacity(), 22);
        Assert.assertEquals(hashMap.getItemsInSlots(), 13);
    }

    @Test
    public void testGetValue() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(99, "test1");
        hashMap.put(1, "test3");
        hashMap.put(9, "test2");
        hashMap.put(98, "test9");
        hashMap.put(2, "test8");
        hashMap.put(8, "test0");
        hashMap.put(97, "test6");
        hashMap.put(3, "test4");
        hashMap.put(10, "test5");

        System.out.println(hashMap.get(10));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(97));
        System.out.println(hashMap.get(98));
        System.out.println(hashMap.get(1));

    }

    @Test
    public void testRemove() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(99, "test1");
        hashMap.put(1, "test3");
        hashMap.put(9, "test2");
        hashMap.put(98, "test9");
        hashMap.put(2, "test8");
        hashMap.remove(2);
        Assert.assertNull(hashMap.get(2));
        hashMap.put(8, "test0");
        hashMap.put(2, "test999999998");
        hashMap.put(97, "test6");
        hashMap.put(3, "test4");
        hashMap.put(10, "test5");


        Assert.assertEquals(hashMap.get(2), "test999999998");
        Assert.assertEquals(hashMap.get(8), "test0");
        Assert.assertEquals(hashMap.get(10), "test5");
    }

    @Test
    public void testRemoveLargeAmount() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(99, "test1");
        hashMap.put(1, "test3");
        hashMap.put(9, "test2");
        hashMap.put(98, "test9");
        hashMap.put(2, "test8");
        hashMap.put(8, "test0");
        hashMap.remove(1);
        hashMap.remove(8);
        hashMap.remove(98);
        hashMap.put(453, "tes238989230");
        hashMap.put(2, "test999999998");
        hashMap.put(97, "test6");
        hashMap.put(3, "test4");
        hashMap.put(10, "test5");
        hashMap.remove(2);
        hashMap.remove(9);
        try {
            hashMap.remove(8);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "Item does not exist or is deleted already");
        }
        hashMap.remove(3);
        hashMap.put(4, "test9");
        hashMap.put(5, "test8");
        hashMap.put(6, "test0");
        hashMap.put(7, "test6");
        hashMap.put(9, "test0");
        hashMap.put(10, "test6");
        hashMap.put(11, "test4");
        try {
            hashMap.remove(909090);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "Item does not exist or is deleted already");
        }
        hashMap.put(12, "test5");
        hashMap.put(13, "test5");
        hashMap.remove(97);
        try {
            hashMap.remove(3);
        } catch (NoSuchElementException e) {
            Assert.assertEquals(e.getMessage(), "Item does not exist or is deleted already");
        }
        hashMap.remove(13);
        hashMap.remove(7);
        hashMap.remove(12);
        hashMap.put(8, "tasdfest4");
        hashMap.put(10, "tes1sdft6");
    }

    @Test
    public void testRemoveWithResize() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(99, "test1");
        hashMap.put(1, "test3");
        hashMap.put(98, "test9");
        hashMap.put(2, "test8");
        hashMap.put(8, "test0");
        hashMap.put(453, "tes238989230");
        hashMap.put(2, "test999999998");
        hashMap.put(97, "test6");
        hashMap.put(3, "test4");
        hashMap.put(5, "test8");
        hashMap.put(6, "test0");
        hashMap.put(9, "test0");
        hashMap.put(10, "test6");
        hashMap.put(11, "test4");
        Assert.assertEquals(hashMap.getCapacity(), 22);
        Assert.assertEquals(hashMap.getItemsInSlots(), 13);

        hashMap.remove(2);
        hashMap.remove(8);
        hashMap.remove(453);
        hashMap.remove(11);
        Assert.assertEquals(hashMap.getCapacity(), 22);
        Assert.assertEquals(hashMap.getItemsInSlots(), 9);
        hashMap.remove(97);
        hashMap.remove(3);
        hashMap.remove(5);
        hashMap.remove(6);
        hashMap.remove(10);
        hashMap.remove(99);
        hashMap.remove(1);
        hashMap.remove(98);
        Assert.assertEquals(hashMap.getCapacity(), 22);
        Assert.assertEquals(hashMap.getItemsInSlots(), 1);
    }
}