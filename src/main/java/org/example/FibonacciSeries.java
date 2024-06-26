package org.example;

public class FibonacciSeries {

    static void fib(int n){
        int n1 = 0, n2 = 1;

        for (int i=0; i<n; i++){
            System.out.print(n1+ " ");

            int n3 = n2 + n1;
            n1 =n2;
            n2 = n3;
        }
    }

    public static void main(String[] args){
        fib(10);
    }
}
