package com.xinzhe.categories.solutions.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/2/29 18:01
 * Title : 3. 无重复字符的最长子串
 * Description : 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * link : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * Level : medium
 * Comment : same as top100/medium.003
 */
public class Leetcode003 {
    public static void main(String[] args) {
        String s = "abcabcbbadc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        while (right < s.length()) {
            char rightChar = s.charAt(right++);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while (map.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
