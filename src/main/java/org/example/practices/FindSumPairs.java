package org.example.practices;
import java.util.HashMap;

public class FindSumPairs {

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 6, 2, 9};
        int sum = 11;

        findSumPairs(arr, sum);
    }

    public static void findSumPairs(int[] arr, int sum) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = sum - arr[i];
            if (map.containsKey(complement)) {
                System.out.println("(" + map.get(complement) + "," + i + ")");
            } else {
                map.put(arr[i], i);
            }
        }
    }
}