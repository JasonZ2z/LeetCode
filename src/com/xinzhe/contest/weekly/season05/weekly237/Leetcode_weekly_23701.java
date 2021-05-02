package com.xinzhe.contest.weekly.season05.weekly237;

/**
 * @author Xin
 * @date 2021/04/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23701 {
    public static void main(String[] args) {
        Leetcode_weekly_23701 lc = new Leetcode_weekly_23701();
    }

    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        if(n < 26) return false;
        int[] arr = new int[26];
        for (char c : sentence.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i : arr) {
            if(i == 0) return false;
        }
        return true;

    }
}
