package com.xinzhe.contest.weekly.season05.weekly238;

import java.util.List;

/**
 * @author Xin
 * @date 2021/04/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23803 {
    public static void main(String[] args) {
        Leetcode_weekly_23803 lc = new Leetcode_weekly_23803();
        String s = "eauoiouieaaoueiuaieoeauoiaueoiaeoiuieuaoiaeouiaueo";
        System.out.println(lc.longestBeautifulSubstring(s));
    }

    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        List<Character> dict = List.of('a', 'e', 'i', 'o', 'u');
        int[] dp = new int[n];
        dp[0] = word.charAt(0) == 'a' ? 1 : 0;
        int max = 0;
        for (int i = 1; i < n; ++i) {
            if(word.charAt(i) == 'a') {
                if(word.charAt(i -1) == 'a') {
                    dp[i] = dp[i-1] + 1;
                } else{
                    dp[i] = 1;
                }
                continue;
            }
            if(dp[i-1] > 0 ) {
                int a = dict.indexOf(word.charAt(i-1));
                int b = dict.indexOf(word.charAt(i));
                if(a == b || b - a == 1){
                    dp[i] = dp[i-1] + 1;
                    if(word.charAt(i) == 'u') {
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        return max;
    }
}
