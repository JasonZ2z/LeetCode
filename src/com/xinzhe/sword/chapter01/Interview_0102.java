package com.xinzhe.sword.chapter01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/6/10
 * Title : 01.02. Check Permutation LCCI
 * Description : Given two strings,write a method to decide if one is a permutation of the other.
 * link : https://leetcode-cn.com/problems/check-permutation-lcci
 * Level : Easy
 */
public class Interview_0102 {

    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return map.values().stream().noneMatch(a -> a != 0);
    }

    public static void main(String[] args) {
        System.out.println((char) 2);
    }
}
