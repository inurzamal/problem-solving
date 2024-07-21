package org.example.syneMultithreading.day2;

import java.util.concurrent.CyclicBarrier;

class Lab6Helper implements Runnable{
    private CyclicBarrier barrier;

    public Lab6Helper(CyclicBarrier barrier) {
        super();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println("starting from Pune " + Thread.currentThread().getName());
            Thread.sleep((int)Math.random()*1000);
            System.out.println("reached Satara and waiting for others " + Thread.currentThread().getName());

            barrier.await();
            System.out.println("starting from Satara " + Thread.currentThread().getName());
            Thread.sleep((int)Math.random()*1000);
            System.out.println("reached Kolhapur and waiting for others " + Thread.currentThread().getName());

            barrier.await();
            System.out.println("starting from Kolhapur " + Thread.currentThread().getName());
            Thread.sleep((int)Math.random()*1000);
            System.out.println("reached Goa and waiting for others " + Thread.currentThread().getName());
        }
        catch(Exception e) {}
    }
}
public class Lab6 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Thread t1 = new Thread(new Lab6Helper(barrier), "car1");
        Thread t2 = new Thread(new Lab6Helper(barrier), "car2");
        Thread t3 = new Thread(new Lab6Helper(barrier), "car3");
        t1.start();
        t2.start();
        t3.start();
    }
}
