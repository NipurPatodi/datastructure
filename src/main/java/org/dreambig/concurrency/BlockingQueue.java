package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue implements IQuestion {
    @Override
    public String getQuestion() {
        return "mplement a blocking queue with a maximum capacity. The queue should support the following operations:\n" +
                "\n" +
                "enqueue(item): Adds an item to the back of the queue. If the queue is full, the operation should block until space becomes available.\n" +
                "dequeue(): Removes and returns an item from the front of the queue. If the queue is empty, the operation should block until an item is available.\n" +
                "You need to design the blocking queue in such a way that multiple producer threads can enqueue items, and multiple consumer threads can dequeue items.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return "Use of awiat and singleAll";
    }
    public static  class ThreadSafeDeque{
        private final Queue<Integer> queue ;
        private final int maxSize;
        private final Lock lock ;
        private final Condition notFull;
        private final Condition notEmpty;

        public ThreadSafeDeque(int size){
            this.queue = new LinkedList<Integer>();
            this.maxSize = size;
            this.lock = new ReentrantLock();
            this.notFull = this.lock.newCondition();
            this.notEmpty = this.lock.newCondition();
        }

        public int deque() throws InterruptedException{
            this.lock.lock();

            try {
                // Wait until Queue is empty
                while(queue.isEmpty())
                {
                    // Wait for other
                    notEmpty.await();
                }

                // Since item is remove so not full
                 return queue.poll();

            }finally {
                notFull.signalAll();
                this.lock.unlock();
            }
        }

        public void enque(int ip) throws InterruptedException{
            this.lock.lock();
            try {
                while (queue.size()>maxSize){
                    notFull.await();
                }
                queue.offer(ip);
                notEmpty.signalAll();


            }
            finally {
                this.lock.unlock();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeDeque queue = new ThreadSafeDeque(10);
        // Writers
        Thread p1 = new Thread(()->{
            for (int i=0;i<12;i++){
                try {
                    queue.enque(i);
                    System.out.println("Thread "+Thread.currentThread().getName()+" push "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread p2 = new Thread(()->{
            for (int i=12;i<15;i++){
                try {
                    queue.enque(i);
                    System.out.println("Thread "+Thread.currentThread().getName()+" push "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread c1 = new Thread(()->{
            for (int i=1;i<12;i++){
                try {
                    int res =queue.deque();
                    System.out.println("Thread "+Thread.currentThread().getName()+" pull "+res);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread c2 = new Thread(()->{
            for (int i=12;i<15;i++){
                try {
                    int res =queue.deque();
                    System.out.println("Thread "+Thread.currentThread().getName()+" pull "+res);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        p1.join();
        p2.join();
        c1.join();
        c2.join();
    }
}
