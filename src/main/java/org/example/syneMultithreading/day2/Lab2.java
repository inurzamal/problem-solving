// Executors.newCachedThreadPool()

package org.example.syneMultithreading.day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab2Helper1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Lab2Helper2 Run method of thread " + Thread.currentThread().getName() + " invoked ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public class Lab2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("In thread " + Thread.currentThread().getName());
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new Lab2Helper1());
        }
        Thread.sleep(10000);
        for (int i = 0; i < 5; i++) {
            service.execute(new Lab2Helper1());
        }
        service.shutdown();
    }
}