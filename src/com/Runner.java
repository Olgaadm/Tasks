package com;

import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Runner {

    public static void main(String[] args) {
        int numberOfProducers = 5;
        int numberOfConsumers = 6;
        int numberOfStrings = 1000;
        String stopWord = "STOP";
        // Add switch for case with timeout and case with stop word
        boolean runCaseWithStopWord = true;
        ArrayBlockingQueue<String> sharedQueue = new ArrayBlockingQueue<>(numberOfStrings * numberOfProducers + numberOfConsumers);
        CopyOnWriteArrayList<Thread> producersCollection = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Thread> consumerCollection = new CopyOnWriteArrayList<>();
        TreeSet<String> itemsToPrint = new TreeSet<>();

        for (int i = 0; i < numberOfProducers; i++) {
            Thread producer = new Thread(new Producer(sharedQueue, numberOfStrings));
            producer.setDaemon(true);
            producersCollection.add(producer);
            producer.start();
        }

        for (Thread thread : producersCollection) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Producer thread " + thread.getName() + " was interrupted");
            }
        }

        if (runCaseWithStopWord) {
            for (int k = 0; k < numberOfConsumers; k++) {
                sharedQueue.add(stopWord);
            }
        }

        for (int j = 0; j < numberOfConsumers; j++) {
            Thread consumer;

            if (runCaseWithStopWord) {
                consumer = new Thread(new ConsumerWithStopWord(sharedQueue, itemsToPrint));
            } else {
                consumer = new Thread(new ConsumerWithTimeout(sharedQueue, itemsToPrint));
            }
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
