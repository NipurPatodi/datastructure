package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCounter implements IQuestion {
    @Override
    public String getQuestion() {
        return "You are given a class ConcurrentCounter which has a counter value." +
                " Multiple threads will increment this counter simultaneously." +
                " Implement the ConcurrentCounter class with proper synchronization mechanisms " +
                "to ensure that the counter is incremented safely without race conditions.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        this.counter.incrementAndGet();
    }

    public int get(){
        return this.counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentCounter cntr = new ConcurrentCounter();
        List<Thread> threads=  new ArrayList<>();
        for( int i =0;i<500;i++){
            Thread t = new Thread(){
                public  void run(){
                    cntr.increment();
                    System.out.println(Thread.currentThread().getId()+" got value "+cntr.get());
                }
            };
            threads.add(t);
        }
        for (Thread t: threads){
            t.start();
            t.join();
        }
        System.out.println(cntr.get());


    }
}
