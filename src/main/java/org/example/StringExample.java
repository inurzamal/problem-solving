package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringExample {

    public static void main(String[] args) {
        String str = "Hello Java World";

        Map<String, Long> map =
                Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(map);

//        String[] strArray = str.split(" ");
//        List<String> list = new ArrayList<>();
//        for (String s: strArray){
//            list.add(s);
//        }
//        Map<Integer, List<String>> map1 = list.stream().collect(Collectors.groupingBy(String::length));
//        System.out.println(map1);

    }
}
