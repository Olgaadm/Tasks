package com.additionalImplementation;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer extends ConsumerWrapper implements Runnable {

    public Consumer(ArrayBlockingQueue<String> queue, TreeSet<String> itemsToPrint, AtomicInteger numberOfActiveProducers) {
        super(queue, itemsToPrint, numberOfActiveProducers);
    }

    @Override
    public void run() {
        char[] SKIPPILL = {'s', 'k', 'i', 'p', 'c', 'o', 'n', 's', 'u', 'm', 'e', 'r'};
        while (true) {
            String itemFromQueue = super.get();
            if (itemFromQueue == null) {
                System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " was stopped");
                return;
            }
            if (itemFromQueue != null && !itemFromQueue.equals(Arrays.toString(SKIPPILL))) {
                super.accept(itemFromQueue);
                System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " consumed item");
            }
        }
    }
}
