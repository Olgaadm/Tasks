package com;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {

    private final ArrayBlockingQueue<String> queue;
    private final int numberOfStrings;

    public Producer(ArrayBlockingQueue<String> queue, int numberOfStrings) {
        this.queue = queue;
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numberOfStrings; i++) {
                queue.put(UUID.randomUUID().toString());
                System.out.println("Producer in Thread " + Thread.currentThread().getName() + " produced UUID");
            }
        } catch (InterruptedException ignored) {
        }
    }
}
