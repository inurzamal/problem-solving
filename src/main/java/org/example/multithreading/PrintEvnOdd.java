package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EvenTask implements Runnable {

    private final Object lock;

    EvenTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i=0; i<=10; i++){
                if (i%2 == 0)
                    System.out.println(Thread.currentThread().getName()+": "+i);
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.notifyAll();
        }
    }
}

class OddTask implements Runnable{
    private final Object lock;

    OddTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i=0; i<=10; i++){
                if (i%2 == 1)
                    System.out.println(Thread.currentThread().getName()+": "+i);
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.notifyAll();
        }
    }
}
public class PrintEvnOdd {

    public static void main(String[] args) {

        Object lock = new Object();

//        Thread t1 =new Thread(new EvenTask(lock));
//        Thread t2 = new Thread(new OddTask(lock));
//        t1.start();
//        t2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new EvenTask(lock));
        executorService.submit(new OddTask(lock));

        executorService.shutdown();
    }
}
