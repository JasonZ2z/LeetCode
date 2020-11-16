package com.xinzhe.contest.weekly.season05.weekly215;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/11/15
 * Title :
 * Description : 
 * link :
 * Level : Easy
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
