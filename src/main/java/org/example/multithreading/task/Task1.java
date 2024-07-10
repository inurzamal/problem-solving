package org.example.multithreading.task;

public class Task1 extends Thread {
    private final Object lock;

    public Task1(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + ": " + i);
                if (i == 5) {
                    try {
                        lock.wait(); // wait for other task to notify, here Task2 will notify
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notifyAll();
        }
    }
}