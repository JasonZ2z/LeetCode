package com.xinzhe.contest.weekly.weekly170;

/**
 * @Author Xin
 * @create 2020/5/28
 * Title : 1312. 让字符串成为回文串的最少插入次数
 * Description :  给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。请你返回让 s 成为回文串的 最少操作次数 。
 * link : https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 * Level : Hard
 * Comment 170周赛04
 */

public class Leetcode_weekly_17004 {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder tmp = new StringBuilder(s).reverse();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == tmp.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][n];
    }
}
