package org.example.others;

public class SingletonDemo {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.showMessage();
    }

}
