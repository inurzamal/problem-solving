package org.example.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringtoInteger {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "5", "7");
        List<Integer> numList = new ArrayList<>();
        for (String str: list){
            numList.add(Integer.valueOf(str)); //numList.add(Integer.parseInt(str));
        }
        System.out.println(numList);
    }
}
