package org.example.multithreading.task;

public class Task1 extends Thread {
    public void run(){
        for (int i=0; i<10; i++){
            System.out.println("Thread Name: "+Thread.currentThread().getName()+": "+ i);
        }
    }
}