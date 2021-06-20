package com.xinzhe.contest.biweeekly.s1.biweekly49;

/**
 * @author Xin
 * @date 2021/04/03
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4902 {
    public static void main(String[] args) {
        Leetcode_biweekly_4902 lc = new Leetcode_biweekly_4902();
    }
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return areSentencesSimilar(s2, s1);
        }
        s1 = "a " + s1 + " b";
        s2 = "a " + s2 + " b";
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;
        for (; i < m; ++i) {
            if(!arr1[i].equals(arr2[i])) break;
        }
        if(i == m) return true;
        for (; j < m; ++j) {
            if(!arr1[m-1-j].equals(arr2[n-1-j])) break;
        }
        return i + j == m;
    }
}