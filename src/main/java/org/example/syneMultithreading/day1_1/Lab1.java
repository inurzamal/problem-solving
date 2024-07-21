package org.example.syneMultithreading.day1_1;

class Bank {
    public int balance = 0;
}

class Deposit implements Runnable {
    private Bank bank;

    public Deposit(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 100; i++) {
                synchronized (bank) {
                    int b = bank.balance;
                    b++;
                    bank.balance = b;
                    if (bank.balance > 0) {
                        System.out.println("........Notifying threads ");
                        bank.notify();
                    }
                    // Thread.sleep((int)(Math.random()*1000));
                    System.out.println("In Deposit, current balance is " + bank.balance);
                }
            }
        } catch (Exception e) {
        }
    }
}

class Widraw implements Runnable {
    private Bank bank;

    public Widraw(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 100; i++) {
                synchronized (bank) {
                    if (bank.balance <= 0) {
                        System.out.println("Bank balance is <= 0 , just before wait... ");
                        bank.wait();
                    }

                    int b = bank.balance;
                    b--;
                    bank.balance = b;
                    System.out.println("In Widraw, current balance is " + bank.balance);
                }

            }
            System.out.println(
                    "Thread " + Thread.currentThread().getName() + " over, current balance is " + bank.balance);
        } catch (Exception e) {
        }
    }
}

public class Lab1 {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Thread t1 = new Thread(new Deposit(bank), "Deposit");
        Thread t2 = new Thread(new Widraw(bank), "Widraw");
        t1.start();
        t2.start();

        t1.join(); // stop current thread and let t1 finish
        t2.join(); // stop current thread and let t2 finish
        System.out.println("Final Balance is " + bank.balance);
    }
}