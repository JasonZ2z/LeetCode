package com.xinzhe.test;

import java.util.HashMap;
import java.util.Map;

public class testMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(1) > map.get(2) ? map.get(1) : map.get(2));
    }
}
