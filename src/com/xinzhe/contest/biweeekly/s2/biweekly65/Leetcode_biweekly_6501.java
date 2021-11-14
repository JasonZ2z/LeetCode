package com.xinzhe.contest.biweeekly.s2.biweekly65;

/**
 * @author Xin
 * @date 2021/11/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6501 {
    public static void main(String[] args) {
        Leetcode_biweekly_6501 lc = new Leetcode_biweekly_6501();

    }
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c : word1.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            arr2[c - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if(Math.abs(arr1[i] - arr2[i]) > 3) return false;
        }
        return true;
    }
}