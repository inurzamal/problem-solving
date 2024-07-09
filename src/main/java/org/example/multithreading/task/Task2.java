package org.example.multithreading.task;

public class Task2 implements Runnable {
    @Override
    public void run(){
        for (int i=10; i<20; i++){
            System.out.println("Thread Name: "+Thread.currentThread().getName()+": "+ i);
        }
    }
}