package com;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Runner {

    public static void main(String[] args) {
        int numberOfProducers = 5;
        int numberOfConsumers = 5;

        ArrayBlockingQueue<String> sharedQueue = new ArrayBlockingQueue<>(numberOfProducers);
        CopyOnWriteArrayList<Thread> producersCollection = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Thread> consumerCollection = new CopyOnWriteArrayList<>();
        TreeSet<String> itemsToPrint = new TreeSet<>();

        for (int i = 0; i < numberOfProducers; i++) {
            Thread producer = new Thread(new Producer(sharedQueue, producersCollection));
            producer.setDaemon(true);
            producer.start();
        }

        for (int j = 0; j < numberOfConsumers; j++) {
            Thread consumer = new Thread(new Consumer(sharedQueue, producersCollection, itemsToPrint));
            consumer.setDaemon(true);
            consumerCollection.add(consumer);
            consumer.start();
        }

        for (Thread thread : consumerCollection) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Consumer thread " + thread.getName() + " was interrupted");
            }
        }

        for (String item : itemsToPrint) {
            System.out.println(item);
        }
    }
}
