package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondHighestNumber {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 3, 6, 7, 8, 1);
        Collections.sort(list);
        int size = list.size();
        System.out.println(list.get(size - 2));
    }
}
