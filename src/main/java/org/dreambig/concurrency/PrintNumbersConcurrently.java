package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PrintNumbersConcurrently implements IQuestion {
    @Override
    public String getQuestion() {
        return "Write a Java program that uses two threads to print numbers from 1 to 10 concurrently. One thread should print odd numbers, and the other should print even numbers. Implement proper synchronization to ensure that numbers are printed in the correct order.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public static class InOrderNumberPrinter {
        private volatile boolean isOdd;
        private volatile boolean isEven;
        private final AtomicInteger ctr = new AtomicInteger(0);
        private final Object lock = new Object();

        public void printOdd() throws InterruptedException {
            while (ctr.get() < 1000) {
                if (!isEven) {
                    System.out.println(String.format("Odd printed by %s is %s", Thread.currentThread().getName(), ctr.incrementAndGet()));
                    synchronized (lock) {
                        isEven = true;
                        isOdd = false;
                    }

                }
            }
        }

        public void printEven() throws InterruptedException {
            while (ctr.get() < 1000) {
                if (!isOdd) {
                    System.out.println(String.format("Even printed by %s is %s", Thread.currentThread().getName(), ctr.incrementAndGet()));
                    synchronized (lock) {
                        isEven = false;
                        isOdd = true;
                    }

                }
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        InOrderNumberPrinter iorn = new InOrderNumberPrinter();
        iorn.isOdd = true;
        Thread odd = new Thread(() -> {
            try {
                iorn.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread even = new Thread(() -> {
            try {
                iorn.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        even.start();
        odd.start();
        even.join();
        odd.join();
    }
}
