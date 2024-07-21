// Lab4 - synchronized

package org.example.syneMultithreading.day1;

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
                    int b = bank.balance;
                    b--;
                    bank.balance = b;
                }
                Thread.sleep((int)(Math.random()*100));
            }
            System.out.println("Thread " + Thread.currentThread().getName()  + " over, current balance is " + bank.balance);
        } catch (Exception e) {
        }
    }
}

public class Lab4 {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        for (int i = 0; i< 5;i++) {
            Thread t1 = new Thread(new Deposit(bank));
            Thread t2 = new Thread(new Widraw(bank));
            t1.start();
            t2.start();
        }
        Thread.sleep(10000);
        System.out.println("Final Balance is " + bank.balance);
    }
}
