package com.xinzhe.order.day05;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(minWindow2(s,t));
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

        int left =0, right =0, match=0, res = 0, minLen = s_len + 1;
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
        return minLen > s_len ? "" : s.substring(res, res+minLen);
    }

    public static String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int p = 0, q = 0, min = s.length() + 1, start = 0;
        while(q < s.length()) {
            char rc = s.charAt(q);
            tmp.put(rc, tmp.getOrDefault(rc, 0) + 1);
            while(helper(map, tmp)) {
                if(q - p + 1 < min) {
                    min = q - p + 1 ;
                    start = p;
                }
                char lc = s.charAt(p);
                tmp.put(lc, tmp.get(lc) - 1);
                p++;
            }
            q++;
        }
        return min > s.length() ?  "" : s.substring(start, start+min);
    }

    private static boolean helper(Map<Character, Integer> map, Map<Character, Integer> tmp) {
        boolean flag = true;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            if(!tmp.containsKey(c) || entry.getValue() > tmp.get(c)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
