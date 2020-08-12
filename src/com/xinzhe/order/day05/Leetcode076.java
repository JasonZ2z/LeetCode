package com.xinzhe.order.day05;

import java.util.HashMap;

/**
 * @author Xin
 * @date 2020/3/12 16:14
 * Title : 76. 最小覆盖子串
 * Description : 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * link : https://leetcode-cn.com/problems/minimum-window-substring/
 * Level : Hard
 */
public class Leetcode076 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        int t_len = t.length();
        int s_len = s.length();
        if(t_len == 0 || s_len == 0 || s_len < t_len) return "";
        HashMap<Character, Integer> tMap = new HashMap<>(t_len);
        HashMap<Character, Integer> sMap = new HashMap<>(t_len);
        for (int i = 0; i < t_len; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left =0, right =0, match=0, res = 0, minLen = s.length();
        while(right < s_len){
            char rightChar = s.charAt(right++);
            if(tMap.containsKey(rightChar)){
                sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);
                if(tMap.get(rightChar).equals(sMap.get(rightChar))){
                    match++;
                }
            }
            while (match == tMap.size()){
                if(right - left < minLen){
                    minLen = right -left;
                    res = left;
                }
                char leftValue = s.charAt(left++);
                if(tMap.containsKey(leftValue)){
                    sMap.put(leftValue, sMap.get(leftValue)-1);
                    if(tMap.get(leftValue) > sMap.get(leftValue)){
                        match--;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(res, res+minLen);
    }
}
