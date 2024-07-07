package org.example.others;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        // Create a HashMap.
        HashMap<String, Integer> hmap = new HashMap<>();

        // Checking HashMap is empty or not.
        boolean empty = hmap.isEmpty(); // true
        System.out.println("Is HashMap empty: " + empty);

        // Adding entries in the hash map.
        hmap.put("John", 24); // hmap.size() is 1.
        hmap.put("Deep", 22); // hmap.size() is 2.
        hmap.put("Shubh", 15); // hmap.size() is 3.
        hmap.put("Riky", 22); // hmap.size() is 4. // Adding duplicate value.
        hmap.put("Mark", 30); // hmap.size() is 5.
        hmap.put("Mark", 40); // hmap.size() is still 5. // Adding duplicate key
        // will replace previous value of the key
        System.out.println("Entries in HashMap: " + hmap); // {Riky=22, Shubh=15, John=24, Mark=40, Deep=22}
        int size = hmap.size(); // 5
        System.out.println("Size of HashMap: " + size);

        hmap.remove("Riky"); // {Shubh=15, John=24, Mark=40, Deep=22}
        System.out.println("After Removing entry for Riky "+hmap);

        hmap.replace("John", 33); // {Shubh=15, John=33, Mark=40, Deep=22}
        System.out.println("Updated HashMap: " + hmap);

        // Adding null key and value.
        hmap.put(null, null); // {null=null, Shubh=15, John=33, Mark=40, Deep=22}
        System.out.println("Updated entries in HashMap: " + hmap.size()); // 5
        System.out.println("Searching in HashMap: "+ hmap.get("John")); // 33

    }
}

