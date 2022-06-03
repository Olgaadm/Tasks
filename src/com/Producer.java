package com;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private final ArrayBlockingQueue<String> queue;
    private final int numberOfStrings;
    private final AtomicInteger numberOfActiveProducers;

    public Producer(ArrayBlockingQueue<String> queue, int numberOfStrings, AtomicInteger sharedCounte) {
        this.queue = queue;
        this.numberOfStrings = numberOfStrings;
        this.numberOfActiveProducers = sharedCounte;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numberOfStrings; i++) {
                Thread.sleep(5);
                queue.put(UUID.randomUUID().toString());
                System.out.println("Producer in Thread " + Thread.currentThread().getName() + " produced UUID");
            }
            numberOfActiveProducers.getAndDecrement();
        } catch (InterruptedException ignored) {
        }
    }

}
