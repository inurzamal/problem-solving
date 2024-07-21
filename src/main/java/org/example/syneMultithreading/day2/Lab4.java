package org.example.syneMultithreading.day2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Lab4Helper1 implements Callable<Integer> {
    int no1;
    int no2;

    public Lab4Helper1(int no1, int no2) {
        this.no1 = no1;
        this.no2 = no2;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("in Call method of " + Thread.currentThread().getName() + " with " + no1 + ", " + no2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return no1 + no2;
    }
}

class Lab4Helper implements Runnable {
    int no1;
    int no2;
    private int total;

    public Lab4Helper(int no1, int no2) {
        super();
        this.no1 = no1;
        this.no2 = no2;
    }

    @Override
    public void run() {
        System.out.println("in Run method of " + Thread.currentThread().getName() + " with " + no1 + ", " + no2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        total = no1 + no2;
    }

    public int getTotal() {
        return total;
    }
}

public class Lab4 {
    public static void main(String[] args) throws Exception {
        Lab4Helper runnable = new Lab4Helper(10, 30);
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(runnable, "done");
        System.out.println("....continue");
        System.out.println("Future returned " + future.get());
        System.out.println("Ouput = " + runnable.getTotal());
        Lab4Helper runnable1 = new Lab4Helper(100, 300);

        Future future1 = service.submit(runnable1);
        future1.get();
        System.out.println("Ouput = " + runnable1.getTotal());

        Future<Integer> future2 = service.submit(new Lab4Helper1(1001, 3001));
        System.out.println("waiting for future2 to return data ");
        System.out.println("Total = " + future2.get());
        service.shutdown();
    }
}