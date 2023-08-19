package org.dreambig.concurrency;

public class NotVisible {
    private static boolean ready;
    private  static Long cnt=23L;

    private static  class ReaderTheard extends Thread{
        @Override
        public  void run(){
            while (!ready)
                Thread.yield();
            System.out.println(cnt);

        }

    }

    public static void main(String[] args) {
        ReaderTheard t = new ReaderTheard();
        t.start();
        ready=true;
        cnt= 12L;


    }
}
