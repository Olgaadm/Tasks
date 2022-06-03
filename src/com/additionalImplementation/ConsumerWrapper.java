package com.additionalImplementation;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class ConsumerWrapper implements Supplier<String>, java.util.function.Consumer<String> {

    private final ArrayBlockingQueue<String> queue;
    private final TreeSet<String> itemsToPrint;
    private final AtomicInteger numberOfActiveProducers;

    public ConsumerWrapper(ArrayBlockingQueue<String> queue, TreeSet<String> itemsToPrint, AtomicInteger sharedCounter) {
        this.queue = queue;
        this.itemsToPrint = itemsToPrint;
        this.numberOfActiveProducers = sharedCounter;
    }

    @Override
    public String get() {
        String itemFromQueue = null;
        char[] SKIPPILL = {'s', 'k', 'i', 'p', 'c', 'o', 'n', 's', 'u', 'm', 'e', 'r'};
        try {
            char[] STOPWORD = new char[10];
            itemFromQueue = queue.poll(1, TimeUnit.SECONDS);
            if (itemFromQueue != null && itemFromQueue.equals(Arrays.toString(STOPWORD)) || (itemFromQueue == null && numberOfActiveProducers.get() == 0)) {
                System.out.println(itemFromQueue != null && itemFromQueue.equals(Arrays.toString(STOPWORD)) || (itemFromQueue == null && numberOfActiveProducers.get() == 0));
                return null;
            }
            if (itemFromQueue == null) {
                itemFromQueue = Arrays.toString(SKIPPILL);
            }
        } catch (InterruptedException ignored) {
        }
        return itemFromQueue;
    }

    @Override
    public void accept(String itemFromQueue) {
        itemsToPrint.add(itemFromQueue);
    }

}
