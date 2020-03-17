package com.xinzhe.categories.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/3/1 22:11
 * Title : 76. 最小覆盖子串
 * Description : 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"

 * link : https://leetcode-cn.com/problems/minimum-window-substring
 * Level : hard
 */
public class Leetcode76 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        if(t == null || t.length() == 0) return "";
        if(s == null || s.length() == 0) return "";
        if(s.length() < t.length()) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i) , tmap.getOrDefault(t.charAt(i), 0) +1);
        }
        Map<Character, Integer> smap = new HashMap<>();
        int left = 0, right = 0;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        while (right < s.length()){
            char rightChar = s.charAt(right++);
            if(tmap.containsKey(rightChar)){
                smap.put(rightChar, smap.getOrDefault(rightChar, 0) + 1);
                if(smap.get(rightChar).equals(tmap.get(rightChar))){
                    match++;
                }
            }
            while (match == tmap.size()){
                if(right -left < minLen){
                    result = s.substring(left, right);
                    minLen = right - left;
                }
                char leftChar = s.charAt(left++);
                if(tmap.containsKey(leftChar)){
                    smap.put(leftChar, smap.get(leftChar)-1);
                    if(smap.get(leftChar) < tmap.get(leftChar)){
                        match--;
                    }
                }
            }
        }
        return result;

    }
}
