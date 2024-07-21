package org.example.syneMultithreading.day1;

import java.util.Scanner;
class Lab1Helper extends Thread{
    @Override
    public void run() {
        System.out.println("Run method of thread " + currentThread().getName() + " invoked ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Lab1Helper2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Run method of thread " + Thread.currentThread().getName() + " invoked ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to continue ");
        scanner.nextInt();
        System.out.println("In thread " + Thread.currentThread().getName() );
        Thread t1 = new Lab1Helper();
        t1.start();
        Thread t2 = new Thread(new Lab1Helper2());
        t2.start();

        // use this..
        Runnable r = ()->System.out.println("Run method of thread " + Thread.currentThread().getName() + " invoked ");
        Thread t3 = new Thread(r);
        t3.start();
    }
}