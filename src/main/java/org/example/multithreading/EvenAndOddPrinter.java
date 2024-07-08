package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// Print Even & Odd Numbers in Synchronised order using two threads
public class EvenAndOddPrinter {

    // Shared lock object for synchronization
    private static final Object lock = new Object();

    // Predicate conditions for even and odd numbers
    private static final IntPredicate evenCondition = e -> e % 2 == 0;
    private static final IntPredicate oddCondition = e -> e % 2 != 0;

    public static void main(String[] args) {
        // ExecutorService to manage threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to executor service (one for odd numbers, one for even numbers)
        executor.submit(() -> printResults(oddCondition));
        executor.submit(() -> printResults(evenCondition));

        // Initiates shutdown of executor service after tasks are submitted.
        // This prevents the executor from accepting new tasks, but allows existing tasks to complete.
        executor.shutdown();

        try {
            // Wait up to 5 minutes for tasks to complete
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                // If tasks are not completed within 5 minutes, force shutdown
                System.out.println("Tasks are taking too long to complete. Forcing shutdown...");
                executor.shutdownNow(); // Attempt to interrupt running tasks
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Method to print numbers based on condition (even or odd)
    public static void printResults(IntPredicate condition) {
        IntStream.rangeClosed(1, 10)
                .filter(condition)
                .forEach(EvenAndOddPrinter::task); // Pass each number to task method
    }

    // Task method executed by threads
    public static void task(int i) {
        synchronized (lock) { // Synchronize on the shared lock object
            try {
                System.out.println("Thread Name " + Thread.currentThread().getName() + " : " + i);
                lock.notify(); // Notify other waiting threads
                if (i < 10) {
                    lock.wait(); // Wait for notification to continue
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // Handle interruption
            }
        }
    }
}
