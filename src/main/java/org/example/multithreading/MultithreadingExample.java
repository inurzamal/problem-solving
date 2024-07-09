package org.example.multithreading;

import org.example.multithreading.task.Task1;
import org.example.multithreading.task.Task2;
import org.example.multithreading.task.Task3;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class MultithreadingExample {
    public static void main(String[] args) {

//        Task1 task1 = new Task1();
//        task1.start();

//        Thread thread2 = new Thread(new Task2());
//        thread2.start();


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Task1());
        executorService.submit(new Task2());
        Future<String> future3 = executorService.submit(new Task3());

        try {
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

    }

}
