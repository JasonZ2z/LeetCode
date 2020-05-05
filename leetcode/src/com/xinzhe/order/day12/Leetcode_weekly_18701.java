package com.xinzhe.order.day12;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/5/3
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18701 {
    public static void main(String[] args) {
        System.out.println();

    }
    public static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
            set.add(path.get(0));
        }
        for (String value : map.values()) {
            if(!set.contains(value)){
                return value;
            }
        }
        return "";
    }

}
