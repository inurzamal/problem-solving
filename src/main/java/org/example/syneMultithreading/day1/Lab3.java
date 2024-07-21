package org.example.syneMultithreading.day1;

/**
* Lab3 - when any thread got completed, we need to stop other thread. Let's find winner.
* */

class Lab3Helper implements Runnable {
    private String str;

    public Lab3Helper(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 9 && Lab3.done == false; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i) ;
                Thread.sleep((int)(Math.random()*1000));
            }
            if (Lab3.done == false ) {
                System.out.println( Thread.currentThread().getName() + "  Finished ");
                Lab3.done = true;
                Lab3.winner = str;
            }
        } catch (Exception e) {
        }
    }
}
public class Lab3 {
    static boolean done =false;
    static String winner = "";
    public static void main(String[] args) {
        //	Scanner scanner = new Scanner(System.in);
        //	System.out.println("Enter a number to continue ");
        //	scanner.nextInt();
        System.out.println("Starting main");
        Thread t1 = new Thread(new Lab3Helper("car1"));
        t1.setName("car1");
        Thread t2 = new Thread(new Lab3Helper("car2"));
        t2.setName("car2");
        Thread t3 = new Thread(new Lab3Helper("car3"), "car3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Closing main");
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Winner Car is " + Lab3.winner );
    }
}