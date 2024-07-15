package org.example.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Example of map() and flatMap() using List
public class FlatMapExample {

    public static void main(String[] args) {
        // map() example
        List<String> fruits = Arrays.asList("Apple", "Mango", "Banana", "Orange");
        List<Integer> countEachCharacter = fruits.stream().map(f -> f.length()).collect(Collectors.toList());
        System.out.println(countEachCharacter);


        //flatMap() Example
        List<List<Integer>> listOfList = new ArrayList<>();
        listOfList.add(Arrays.asList(1,2,3));
        listOfList.add(Arrays.asList(4,5,6));
        listOfList.add(Arrays.asList(7,8,9));
        System.out.println(listOfList);
        List<Integer> list = listOfList.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(list);

    }

}
