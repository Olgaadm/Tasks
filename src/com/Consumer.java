package com;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Consumer implements Runnable {

    private final ArrayBlockingQueue<String> queue;
    private final CopyOnWriteArrayList<Thread> producersCollection;
    private final TreeSet<String> itemsToPrint;


    public Consumer(ArrayBlockingQueue<String> queue, CopyOnWriteArrayList<Thread> producersCollection, TreeSet<String> itemsToPrint) {
        this.queue = queue;
        this.producersCollection = producersCollection;
        this.itemsToPrint = itemsToPrint;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    if (producersCollection.size() == 0 && queue.isEmpty()) {
                        queue.notifyAll();
                        System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " was stopped");
                        return;
                    } else {
                        String itemFromQueue = queue.take();
                        addItemToTreeSet(itemFromQueue);
                        System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " consumed item");
                    }
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

