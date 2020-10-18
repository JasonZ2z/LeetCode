package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21101 {
    public static void main(String[] args) {
        Leetcode_weekly_21101 lc = new Leetcode_weekly_21101();
        int[] arr = {3,5};
    }
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                max = Math.max(max, i - map.get(c) - 1);
                //map.put(c, i);
            } else {
                map.put(c, i);
            }
        }
        return max;
    }
}
