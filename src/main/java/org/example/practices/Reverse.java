package org.example.practices;

public class Reverse {

    private static void reverseStr(String str) {
        char[] charArray = str.toCharArray();
        for (int i = charArray.length-1; i >= 0; i--){
            System.out.print(charArray[i]+ " ");
        }
    }

    static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int[] arr, int n){
        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        String str = "Hello";
        reverseStr(str);

        System.out.println();

        int[] arr = {1,2,3,4,5};
        reverseArray(arr, 0, arr.length-1);
        printArray(arr, arr.length);

    }
}
