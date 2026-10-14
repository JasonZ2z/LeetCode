package com.xinzhe.top100.medium;


/**
 * @author Xin
 * @date 2020/2/29 18:01
 * Title : 3. 无重复字符的最长子串
 * Description : 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * link : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * Level : Medium
 */
public class Leetcode003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        int max = 0;
        int left = 0;
        // last[c] 记录字符 c 最后出现位置的下一位，0 表示尚未出现
        int[] last = new int[128];
        char[] chars = s.toCharArray();
        for (int right = 0; right < n; right++) {
            char c = chars[right];
            if (last[c] > left) left = last[c];
            max = Math.max(max, right - left + 1);
            last[c] = right + 1;
            if (max >= n - left) break;
        }
        return max;
    }
}
