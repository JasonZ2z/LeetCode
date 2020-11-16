package com.xinzhe.contest.weekly.season05.weekly215;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/11/15
 * Title : 1657. 确定两个字符串是否接近
 * Description :  如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *              操作 1：交换任意两个 现有 字符。例如，abcde -> aecdb
 *              操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 *              你可以根据需要对任意一个字符串多次使用这两种操作。给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * link : https://leetcode-cn.com/problems/determine-if-two-strings-are-close
 * Level : Medium
 */
public class Leetcode_weekly_21502 {
    public static void main(String[] args) {
        Leetcode_weekly_21502 lc = new Leetcode_weekly_21502();
        int[] arr = {3,5};
    }
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(m != n) return false;

        int[] w1 = new int[26];
        int[] w2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
            set2.add(c);
        }
        if(set1.size() != set2.size()) return false;
        Arrays.sort(w1);
        Arrays.sort(w2);


        for (int i = 0; i < 26; ++i) {
            if(w1[i] != w2[i]) return false;
        }
        for (Character c : set1) {
            if(!set2.contains(c)) return false;
        }
        return true;
    }
}
