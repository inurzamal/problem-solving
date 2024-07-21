/**
 * Lab3 - when any thread got completed, we need to stop other thread. Let's find winner.
 * */
package org.example.syneMultithreading.day2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Lab5Helper implements Runnable {
    private String str;
    private CountDownLatch latch;

    public Lab5Helper(String str, CountDownLatch latch) {
        this.str = str;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 9 && Lab5.winner.equals(""); i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                Thread.sleep((int) (Math.random() * 1000));
            }
            if (Lab5.winner.equals("")) {
                System.out.println(Thread.currentThread().getName() + "  Finished ");
                Lab5.winner = str;
            }
        } catch (Exception e) {
        }
        System.out.println("Closing thread "  + Thread.currentThread().getName());
        latch.countDown();
    }
}

public class Lab5 {
    static String winner = "";

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("Starting main");
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new Lab5Helper("car1", latch));
        service.execute(new Lab5Helper("car2", latch));
        service.execute(new Lab5Helper("car3", latch));
        System.out.println("Closing main");
        latch.await();
        System.out.println("Winner Car is " + Lab5.winner);
        service.shutdown();
    }
}