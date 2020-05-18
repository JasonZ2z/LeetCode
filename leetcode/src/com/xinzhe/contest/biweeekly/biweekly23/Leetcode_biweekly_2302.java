package com.xinzhe.contest.biweeekly.biweekly23;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/4/4 22:53
 * Title : 5362. 构造 K 个回文字符串
 * Description : 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 *              如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 * link : https://leetcode-cn.com/problems/construct-k-palindrome-strings
 * Level : Medium
 * Comment : 23双周赛02
 */
public class Leetcode_biweekly_2302 {
    public static void main(String[] args) {
        String s ="cxayrgpe";

        int k = 5;
        System.out.println(canConstruct(s, k));
    }
    public static boolean canConstruct(String s, int k) {
        if(s == null || s.length() == 0) return false;
        int n = s.length();
        if(k > n) return false;
        if(k == n) return true;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int even = 0;
        int odd = 0;

        for (Integer value : map.values()) {
            if(value % 2 == 0){
                even ++;
            } else {
                odd ++;
            }
        }
        if(odd > k) return false;
        int res = odd - even;
        if(res >= 0){
            return res + even <= k;
        } else {
            return true;
        }

    }
}
