package com.Collections.List;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapClass {

    public static void main(String[] args) {

        Map<String, Integer> numbers = new TreeMap<>();// gives the sorted order on the basis of key O(logn)
        Map<String, Integer> numbers1 = new HashMap<>();
        // keys should be unique , if u put same key again so that new value will be override - O(1)


        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Four", 4);
        numbers.put("Five", 5);


        numbers.remove("Three");

//        if(!numbers.containsKey("Two")) {
//            numbers.put("Two", 23);
//        }

//        numbers.putIfAbsent("Two", 23);
        System.out.println(numbers);
        System.out.println(numbers.containsValue(3));

        System.out.println(numbers.isEmpty());

//        for (Map.Entry<String, Integer> e: numbers.entrySet()) {
//            System.out.println(e);
//
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//        }
//
//        for (String key: numbers.keySet()) {
//            System.out.println(key);
//        }
//
//        for(Integer value: numbers.values()) {
//            System.out.println(value);
//        }
    }
}
