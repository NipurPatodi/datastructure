package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentCache implements IQuestion {
    @Override
    public String getQuestion() {
        return "Create a concurrent cache that stores key-value pairs. Multiple threads can read from the cache " +
                "simultaneously, but only one thread should be allowed to write to the cache at a time. Implement read and write methods that ensure thread safety.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }
    static  class ThreadSafeCache<K,V>{
        private final Map<K,V> cache;
        private final ReadWriteLock lock;
        private final Lock readLock;
        private final Lock writeLock;


        public ThreadSafeCache(){
            this.cache = new HashMap<>();
            this.lock = new ReentrantReadWriteLock();
            this.readLock = this.lock.readLock();
            this.writeLock = this.lock.writeLock();
        }

        public void put(K k, V v){
            // Acquiring write lock
            writeLock.lock();
            try {
                this.cache.put(k,v);

            }finally {
                writeLock.unlock();
            }
        }

        public V get(K k){
            this.readLock.lock();
            try{
                return  this.cache.getOrDefault(k,null);
            }finally {
                readLock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCache<Integer, String> cache = new ThreadSafeCache<Integer, String>();
        Thread prod = new Thread(()->{
            int a =12;
           for (int i=0; i<10;i++)
           {   String val ="a_"+i;
               cache.put(i, val);
               System.out.println(" Thread "+Thread.currentThread().getName()+" place k="+i+" v="+val);
           }
        });

        Thread con1 = new Thread(()->{
            for (int i=0; i<5;i++){
                String res= cache.get(i);
                System.out.println(" Thread "+Thread.currentThread().getName()+" got  "+res+" for "+i);
            }
        });
        Thread con2 = new Thread(()->{
            for (int i=2; i<10;i++){
                String res= cache.get(i);
                System.out.println(" Thread "+Thread.currentThread().getName()+" got  "+res+" for "+i);
            }
        });

        prod.start();
        con1.start();
        con2.start();
        prod.join();
        con1.join();
        con2.join();
    }
}
