package com.xinzhe.contest.weekly.season05.weekly221;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/12/27
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22101 {
    public static void main(String[] args) {
        Leetcode_weekly_22101 lc = new Leetcode_weekly_22101();
        int[] arr = {3,5};
    }

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        int n = s.length();
        int a = 0, b = 0;
        for (int i = 0; i < n/2; ++i) {
            if(set.contains(s.charAt(i))) a++;
            if(set.contains(s.charAt(n-i-1))) b++;
        }
        return a == b ;
    }
}
