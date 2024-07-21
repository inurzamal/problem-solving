// Executors.newFixedThreadPool(3);

package org.example.syneMultithreading.day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Lab1Helper extends Thread{
    @Override
    public void run() {
        System.out.println("Lab1Helper class Run() method. " + currentThread().getName() + " invoked ");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
class Lab1Helper2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Lab1Helper2 class Run() method. " + Thread.currentThread().getName() + " invoked ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Lab1 {
    public static void main(String[] args) {

        System.out.println("In thread " + Thread.currentThread().getName() );
        Runnable r = ()->System.out.println("Run method of thread " + Thread.currentThread().getName() + " invoked ");
//        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new Lab1Helper());
        service.execute(new Lab1Helper2());
        service.execute(r); // task is created using Java 8 Lambda expression
        service.shutdown();
    }
}
