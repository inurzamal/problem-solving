//deadlock

package org.example.syneMultithreading.day1;

public class Lab6 {

    public static void main(String[] args) {
        String s1  = "str1";
        String s2 = "str2";
        Thread t1 = new Thread(new Lab6Helper(s1, s2), "t1");
        Thread t2 = new Thread(new Lab6Helper(s1,s2), "t2");

        t1.start();
        t2.start();
    }
}

class Lab6Helper implements Runnable {

    private String str1, str2;

    public Lab6Helper(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run() {
        try {
            synchronized (str1) {
                System.out.println(Thread.currentThread().getName() + " has taken lock on str1 and  waiting");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " taken lock on str1 and trying to lock str2");
                synchronized (str2) {
                    System.out.println(Thread.currentThread().getName() + "  locked str1 and str2 both ");
                    Thread.sleep(10000);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}