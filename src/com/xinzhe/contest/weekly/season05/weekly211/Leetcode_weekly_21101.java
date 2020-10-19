package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/18
 * Title : 1624. 两个相同字符之间的最长子字符串
 * Description : 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *              子字符串 是字符串中的一个连续字符序列。
 * link : https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters
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
            } else {
                map.put(c, i);
            }
        }
        return max;
    }
}
