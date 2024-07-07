package org.example.others;

public class Singleton {

    // Step 1: Declare a private static instance variable (not initialized)
    private static Singleton instance;

    // Step 2: Define a private constructor to prevent instantiation
    private Singleton() {
        // Initialization code here
    }

    // Step 3: Provide a public static method to get the instance
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and fields of the singleton class
    public void showMessage() {
        System.out.println("Hello from Lazy Singleton!");
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.showMessage();
    }
}

