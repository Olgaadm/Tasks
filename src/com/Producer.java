package com;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Producer implements Runnable {

    private final ArrayBlockingQueue<String> queue;

    private final CopyOnWriteArrayList<Thread> producersCollection;

    public Producer(ArrayBlockingQueue<String> queue, CopyOnWriteArrayList<Thread> producersCollection) {
        this.queue = queue;
        this.producersCollection = producersCollection;
    }

    @Override
    public void run() {
        producersCollection.add(Thread.currentThread());
        try {
            int numberOfStringsPerProducer = 1000;
            for (int i = 0; i < numberOfStringsPerProducer; i++) {
                queue.put(UUID.randomUUID().toString());
                System.out.println("Producer in Thread " + Thread.currentThread().getName() + " produced UUID");
            }
        } catch (InterruptedException ignored) {
        } finally {
            producersCollection.remove(Thread.currentThread());
        }
    }
}
