package com.additionalImplementation;

import com.Producer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner {


    public static void main(String[] args) {
        int numberOfProducers = 5;
        int numberOfConsumers = 6;
        int numberOfStrings = 1000;
        char[] STOPWORD = new char[10];
        // Add switch for case with timeout and case with stop word
        boolean runCaseWithStopWord = false;
        ArrayBlockingQueue<String> sharedQueue = new ArrayBlockingQueue<>(numberOfConsumers);
        ArrayList<Thread> producersCollection = new ArrayList<>();
        ArrayList<Thread> consumerCollection = new ArrayList<>();
        AtomicInteger numberOfActiveProducers = new AtomicInteger(0);
        TreeSet<String> itemsToPrint = new TreeSet<>();
        System.out.println("This is " + Arrays.toString(STOPWORD) + " stop words");
        for (int i = 0; i < numberOfProducers; i++) {
            Thread producer = new Thread(new Producer(sharedQueue, numberOfStrings, numberOfActiveProducers));
            producer.setDaemon(true);
            producersCollection.add(producer);
            numberOfActiveProducers.getAndIncrement();
            producer.start();
        }

        for (int j = 0; j < numberOfConsumers; j++) {
            Thread consumer = new Thread(new Consumer(sharedQueue, itemsToPrint, numberOfActiveProducers));
            consumer.setDaemon(true);
            consumerCollection.add(consumer);
            consumer.start();
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
                sharedQueue.add(Arrays.toString(STOPWORD));
            }
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
