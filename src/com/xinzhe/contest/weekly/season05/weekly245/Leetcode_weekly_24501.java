package com.xinzhe.contest.weekly.season05.weekly245;

/**
 * @author Xin
 * @date 2021/06/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24501 {
    public static void main(String[] args) {
        Leetcode_weekly_24501 lc = new Leetcode_weekly_24501();

    }
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] arr = new int[26];
        int count = 0;
        for (String word : words) {
            count += word.length();
            for (char c : word.toCharArray()) {
                arr[c - 'a']++;
            }
        }
        if (count % n != 0) return false;
        for (int i : arr) {
            if(i % n != 0) return false;
        }
        return true;

    }

}
