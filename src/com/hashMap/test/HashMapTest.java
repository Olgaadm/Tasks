package com.hashMap.test;

import com.hashMap.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        hashMap.put(99, "test1");
        hashMap.put(1, "test3");
        hashMap.put(9, "test2");
        hashMap.put(98, "test9");
        hashMap.put(2, "test8");
        hashMap.put(8, "test0");
        hashMap.put(97, "test6");
        hashMap.put(3, "test4");
        hashMap.put(98, "test0");
        hashMap.put(57, "test6");
        hashMap.put(35, "test4");
        hashMap.put(107, "test5");
        hashMap.put(109, "test5");

        Assert.assertEquals(hashMap.getCapacity(), 22);
        Assert.assertEquals(hashMap.getItemsInSlots(), 12);
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
}