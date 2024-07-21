package org.example.syneMultithreading.day2;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Lab3Helper implements Runnable {
    @Override
    public void run() {
        System.out.println("Current Time: " + LocalTime.now());
    }
}


public class Lab3 {
    public static void main(String[] args) {

        //Runnable r = ()-> System.out.println(LocalDateTime.now());

        Lab3Helper lab3Helper = new Lab3Helper();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Scheduling Lab3Helper to run every 2 seconds
        scheduler.scheduleAtFixedRate(lab3Helper, 0, 2, TimeUnit.SECONDS);


    }
}
