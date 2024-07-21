package org.example.syneMultithreading.day1;
/**
* Lab5 - Concurrent List modification
* */

import java.util.ArrayList;
import java.util.List;

//Option 1- Synchronized block
//Option 2 - Collections.synchronizedList(new ArrayList());

class Lab5Helper implements Runnable {
    private List<String> namesList;

    public Lab5Helper(List<String> namesList) {
        super();
        this.namesList = namesList;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (namesList) {
                namesList.add(i + "");
            }
        }
    }
}

public class Lab5 {

    public static void main(String[] args) {
        final List<String> namesList = new ArrayList<>();
        // List<String> namesList = Collections.synchronizedList(new ArrayList());

        for (int i = 1; i <= 5; i++) {
            Thread t1 = new Thread(new Lab5Helper(namesList), "t" + i);
            t1.start();
        }

        Thread.getAllStackTraces().forEach((key, value) -> {
            String threadName = key.getName();
            if (threadName.startsWith("t")) {
                try {
                    key.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println(namesList.size());
    }
}