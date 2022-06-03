package com;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerWithTimeout implements Runnable {

    private final ArrayBlockingQueue<String> queue;
    private final TreeSet<String> itemsToPrint;
    private final AtomicInteger numberOfActiveProducers;

    public ConsumerWithTimeout(ArrayBlockingQueue<String> queue, TreeSet<String> itemsToPrint, AtomicInteger sharedCounter) {
        this.queue = queue;
        this.itemsToPrint = itemsToPrint;
        this.numberOfActiveProducers = sharedCounter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String itemFromQueue = queue.poll(1, TimeUnit.SECONDS);
                if (itemFromQueue == null && numberOfActiveProducers.get() == 0) {
                    return;
                }
                if (itemFromQueue != null) {
                    addItemToTreeSet(itemFromQueue);
                    System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " consumed item");
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void addItemToTreeSet(String itemFromQueue) {
        synchronized (itemsToPrint) {
            itemsToPrint.add(itemFromQueue);
        }
    }
}

