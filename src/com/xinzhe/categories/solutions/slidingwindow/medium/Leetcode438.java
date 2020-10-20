package com.xinzhe.categories.solutions.slidingwindow.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/3/3 15:20
 * Title : 209. 长度最小的子数组
 * Description : 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * link ：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * Level : medium
 */
public class Leetcode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams2(s, p).toString());

    }
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] arr = new int[26];
        for(char c : p.toCharArray()) arr[c - 'a']++;
        int[] crr = new int[26];
        int l = 0;
        for(int i =0; i<n; i++) {
            arr[s.charAt(i) - 'a']++;
            if(i - l + 1 == m) {
                if(same(arr, crr)) {
                    res.add(l);
                }
                arr[s.charAt(l++) - 'a']--;
            }
        }
        return res;
    }

    private static boolean same(int[] arr, int[] crr) {
        for (int i = 0; i < 26; ++i) {
            if(arr[i] != crr[i]) return false;
        }
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || s.length() < p.length()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>(p.length());
        Map<Character, Integer> sMap = new HashMap<>(p.length());
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, match = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right++);
            if (pMap.containsKey(rightChar)) {
                sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);
                if (sMap.get(rightChar).equals(pMap.get(rightChar))) {
                    match++;
                }
            }
            while (match == pMap.size()) {
                if (right - left == p.length()) {
                    list.add(left);
                }
                char leftChar = s.charAt(left++);
                if (pMap.containsKey(leftChar)) {
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                    if (sMap.get(leftChar) < pMap.get(leftChar)) {
                        match--;
                    }
                }
            }
        }
        return list;
    }
}
