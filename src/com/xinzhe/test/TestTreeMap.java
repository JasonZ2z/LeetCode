package com.xinzhe.test;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, map.getOrDefault(1, 0) + 1);
        map.put(1, map.getOrDefault(1, 0) + 1);
        map.put(2, map.getOrDefault(2, 0) + 1);
        map.put(3, map.getOrDefault(3, 0) + 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.headMap(3, true).entrySet()) {
            count += entry.getValue();
        }
        System.out.println(count);

//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//
//        Integer floor = set.floor(4);
//        System.out.println(floor);
//        System.out.println(set.headSet(3, true));
//        System.out.println(set.tailSet(3, true));
    }
}
