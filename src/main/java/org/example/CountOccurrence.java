package org.example;

import java.util.HashMap;
import java.util.Map;

//Count Frequency of each character
public class CountOccurrence {
    public static void main(String[] args) {
        String str = "Hello World";
        countEachCharacter(str);
    }

    private static void countEachCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();

        for (char c: charArray){
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
