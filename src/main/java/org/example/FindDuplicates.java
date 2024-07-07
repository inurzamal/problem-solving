package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicates {

    private static void findDuplicateElements() {
        List<Integer> list = Arrays.asList(2,3,1,4,5,6,5,8,3,3);
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = list.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
        set1.forEach(i-> System.out.print(i+ " ")); //duplicates
        //set.forEach(i-> System.out.print(i+ " ")); // removed duplicates
    }

    private static void removeDuplicateElements() {
        List<Integer> list = Arrays.asList(2,3,1,4,5,6,5,8,3,3);
        Set<Integer> set = new HashSet<>();
        list.stream().filter(x -> set.add(x)).forEach(i-> System.out.print(i+ " "));
    }

    private static void removeDuplicateCharacter(){
        String str = "Hello";
        Set<Character> set = new LinkedHashSet<>();
        str.chars().filter(x->set.add((char) x)).forEach(i->System.out.print((char)i));
    }

    public static void main(String[] args) {
        findDuplicateElements();
        removeDuplicateElements();
        removeDuplicateCharacter();
    }

}
