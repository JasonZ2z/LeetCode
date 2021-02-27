package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/02/27
 * Title : 395. 至少有 K 个重复字符的最长子串
 * Description : 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * link : https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * Level : Medium
 */
public class Leetcode395 {
    public int longestSubstring(String s, int k) {
        if(k == 1) return s.length();
        if(s.length() < k) return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if(map.get(c) < k) {
                int ans = 0;
                for (String cur : s.split(c + "")) {
                    ans = Math.max(ans, longestSubstring(cur, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}
