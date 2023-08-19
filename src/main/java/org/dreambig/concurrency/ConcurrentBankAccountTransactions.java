package org.dreambig.concurrency;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBankAccountTransactions implements IQuestion {
    @Override
    public String getQuestion() {
        return "You are tasked with implementing a simple banking system that supports concurrent transactions on multiple bank accounts. Each account has a balance, and you need to ensure that transactions are processed concurrently without causing race conditions or inconsistencies in the account balances.\n" +
                "\n" +
                "Implement the following functionalities:\n" +
                "\n" +
                "An Account class with methods to deposit and withdraw funds.\n" +
                "A Bank class that manages a collection of accounts and performs concurrent transactions.\n" +
                "Demonstrate the concurrent transactions by creating multiple threads that simulate depositing and withdrawing funds from different accounts.\n" +
                "Ensure thread safety and proper synchronization to prevent race conditions and ensure that account balances are consistent after concurrent transactions.";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

     static class Account {
        public final String name;
        private final Lock lock = new ReentrantLock();
        private float balance = 0;

        public Account(String name) {
            this.name = name;
        }

        public void deposit(long amt) {
            lock.lock();
            try {
                this.balance += amt;
            } finally {
                lock.unlock();
            }
        }

        public boolean withdraw(long amt) {
            lock.lock();
            try {
                if (amt < this.balance) {
                    this.balance -= amt;
                    return true;
                } else
                    return false;
            } finally {
                lock.unlock();
            }
        }

        public float getBalance() {
            return this.balance;
        }
    }

    public static class Bank{
        public static void main(String[] args) throws InterruptedException {
            Account a= new Account("Nipurs AC");
            Account b= new Account("Ritika AC");
            Thread nprAcc = new Thread(
                ()->{
                   a.deposit(1000);
                   a.withdraw(200);
                   b.deposit(300);
                }
            );

            Thread rtkAcc = new Thread(
                    ()->{
                        b.deposit(1000);
                        b.withdraw(200);
                        a.deposit(300);
                    }
            );
            nprAcc.start();
            rtkAcc.start();
            nprAcc.join();
            rtkAcc.join();
            System.out.println(String.format("A Balance is %s",a.getBalance()));
            System.out.println(String.format("b Balance is %s",b.getBalance()));
        }
    }

}
