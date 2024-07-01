package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueElements {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 2, 6, 5, 7, 5);

        Map<Integer, Long> countMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> unique = list.stream().filter(e-> countMap.get(e) == 1).collect(Collectors.toList());

        System.out.println(unique);


    }
}
