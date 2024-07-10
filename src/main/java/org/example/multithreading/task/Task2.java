package org.example.multithreading.task;

public class Task2 implements Runnable {
    private final Object lock;

    public Task2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 10; i < 20; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + ": " + i);
                if (i == 15) {
                    lock.notify(); // notify waiting threads, here notify Task1 to continue
                    try {
                        lock.wait(); // wait for Task1 to finish its part
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notifyAll();
        }
    }
}