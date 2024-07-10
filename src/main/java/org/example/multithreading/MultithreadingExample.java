package org.example.multithreading;

import org.example.multithreading.task.Task1;
import org.example.multithreading.task.Task2;
import org.example.multithreading.task.Task3;

import java.util.concurrent.*;

/*public class MultithreadingExample {
    public static void main(String[] args) {

//        Task1 task1 = new Task1();
//        task1.start();
//
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

}*/

/*public class MultithreadingExample {
    public static void main(String[] args) {
        Object lock = new Object();

        Task1 task1 = new Task1(lock);
        Task2 task2 = new Task2(lock);

        Thread thread2 = new Thread(task2);
        task1.start();
        thread2.start();

        try {
            task1.join(); // wait for task1 to finish
            thread2.join(); // wait for task2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace(); // use logs
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future3 = executorService.submit(new Task3());

        try {
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}*/


public class MultithreadingExample {
    public static void main(String[] args) {
        Object lock = new Object();

        // Task1 and Task2 managed by ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<?> future1 = executorService.submit(new Task1(lock));
        Future<?> future2 = executorService.submit(new Task2(lock));

        // Wait for Task1 and Task2 to finish
        try {
            future1.get(); // This blocks until Task1 completes
            future2.get(); // This blocks until Task2 completes
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Task3 also managed by ExecutorService
        Future<String> future3 = executorService.submit(new Task3());

        try {
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown(); // initiates shutdown process after submitting all task.
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)){
                System.out.println("Waiting time is more than 60 seconds, Shutting down Task forcefully..");
                executorService.shutdownNow(); // shutdown forcefully in-case it is not terminating within 1 minute
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

