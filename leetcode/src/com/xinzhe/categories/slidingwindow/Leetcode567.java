package com.xinzhe.categories.slidingwindow;

/**
 * @Author Xin
 * @create 2020/3/1 22:11
 * Title : 567. 字符串的排列
 * Description : 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *              换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * link : https://leetcode-cn.com/problems/permutation-in-string/
 * Level : medium
 */
public class Leetcode567 {
    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "eidbaooobab";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion2(s1, s2));
    }
    public static boolean checkInclusion2(String s1, String s2) {
        if(s1 == null || s1.length() == 0) return true;
        if(s2 == null || s2.length() == 0) return false;
        if(s2.length() < s1.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < len1; i++){
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2 - len1; i++) {
            if(matches(s1map, s2map)){
                return true;
            }
            s2map[s2.charAt(i+ len1) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0) return true;
        if(s2 == null || s2.length() == 0) return false;
        if(s2.length() < s1.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int[] s1map = new int[26];
        for (int i = 0; i < len1; i++){
            s1map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= len2-len1; i++){
            int[] s2map = new int[26];
            for (int j = 0; j < len1; j++) {
                s2map[s2.charAt(j+i) - 'a']++;
            }
            if (matches(s1map, s2map)){
                return true;
            }
        }
        return false;
    }

    public  static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
