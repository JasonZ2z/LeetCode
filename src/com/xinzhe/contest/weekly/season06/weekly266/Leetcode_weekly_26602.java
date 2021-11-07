package com.xinzhe.contest.weekly.season06.weekly266;

import java.util.List;

/**
 * @author Xin
 * @date 2021/11/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26602 {
    public static void main(String[] args) {
        Leetcode_weekly_26602 lc = new Leetcode_weekly_26602();
        System.out.println(lc.countVowels("aba"));
    }

    public long countVowels(String word) {
        long res = 0L;
        int n = word.length();
        List<Character> set = List.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < n; i++) {
            if(set.contains(word.charAt(i))) {
               res += (long) (i + 1) * (n - i);
            }
        }
        return res;
    }
}
