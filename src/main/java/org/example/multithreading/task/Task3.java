package org.example.multithreading.task;

import java.util.concurrent.Callable;

public class Task3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 20; i < 30; i++) {
            System.out.println("Thread Name: " + Thread.currentThread().getName() + ": " + i);
            if (i % 2 == 0) {
                Thread.yield(); // yield to allow other threads to execute
            }
        }
        return "Task3 Completed";
    }
}

