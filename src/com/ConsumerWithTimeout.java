package com;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerWithTimeout implements Runnable{

    private final ArrayBlockingQueue<String> queue;
    private final TreeSet<String> itemsToPrint;


    public ConsumerWithTimeout(ArrayBlockingQueue<String> queue, TreeSet<String> itemsToPrint) {
        this.queue = queue;
        this.itemsToPrint = itemsToPrint;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String itemFromQueue = queue.poll(3, TimeUnit.SECONDS);
                addItemToTreeSet(itemFromQueue);
                System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " consumed item");
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void addItemToTreeSet(String itemFromQueue) {
            itemsToPrint.add(itemFromQueue);
    }
}

