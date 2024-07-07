package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CountOccurrenceExample {

    public static void main(String[] args) {
        String str = "Hello Java World";

        // Count occurrence or Frequency of each character
        Map<String, Long> map = Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(map);

        // Count occurrence or Frequency of each character using LinkedHashMap
        LinkedHashMap<String, Long> map1 =
                Arrays.stream(str.toLowerCase()
                        .split(""))
                        .collect(Collectors.groupingBy(c->c,LinkedHashMap::new, Collectors.counting()));
        System.out.println(map1);


        //Count each character in the word
        Map<Integer, List<String>> map2 = Arrays.stream(str.toLowerCase().split(" ")).collect(Collectors.groupingBy(String::length));
        System.out.println(map2);
    }
}
