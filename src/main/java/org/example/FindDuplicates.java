package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicates {

    private static void findDuplicateElements() {
        List<Integer> list = Arrays.asList(2,3,1,4,5,6,5,8,3,3);
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = list.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
        set1.forEach(i-> System.out.print(i+ " "));
    }

    private static void removeDuplicateCharacter(){
        String str = "Hello";
        char[] charArray = str.toCharArray();
        Set<Character> set = new LinkedHashSet();
        for (int i=0; i<charArray.length; i++){
            set.add(charArray[i]);
        }
        System.out.println(set);
    }

    public static void main(String[] args) {
        findDuplicateElements();
        removeDuplicateCharacter();
    }


}
