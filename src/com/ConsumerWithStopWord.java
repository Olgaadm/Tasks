package com;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerWithStopWord implements Runnable {

    private final ArrayBlockingQueue<String> queue;
    private final TreeSet<String> itemsToPrint;


    public ConsumerWithStopWord(ArrayBlockingQueue<String> queue, TreeSet<String> itemsToPrint) {
        this.queue = queue;
        this.itemsToPrint = itemsToPrint;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String stopWord = "STOP";
                String itemFromQueue = queue.take();
                if (itemFromQueue.equals(stopWord)) {
                    System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " was stopped");
                    return;
                } else {
                    addItemToTreeSet(itemFromQueue);
                    System.out.println("Consumer in Thread " + Thread.currentThread().getName() + " consumed item");
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void addItemToTreeSet(String itemFromQueue) {
        itemsToPrint.add(itemFromQueue);
    }
}

