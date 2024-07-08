package org.example.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// Print Even & Odd Numbers in Synchronised order using two threads
public class EvenOddPrinter {

    private static final Object lock = new Object();

    private static final IntPredicate evenCondition = e -> e % 2 == 0;
    private static final IntPredicate oddCondition = e -> e % 2 != 0;

    public static void main(String[] args) {
        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(() -> printResults(oddCondition));
        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(() -> printResults(evenCondition));

        // Wait for both tasks to complete
        CompletableFuture.allOf(oddFuture, evenFuture).join();
    }

    public static void printResults(IntPredicate condition) {
        IntStream.rangeClosed(1, 10)
                .filter(condition)
                .forEach(EvenOddPrinter::task);
    }

    public static void task(int i) {
        synchronized (lock) {
            try {
                System.out.println("Thread Name " + Thread.currentThread().getName() + " : " + i);
                lock.notify();
                if (i < 10) {
                    lock.wait();
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
