package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/10 18:32
 * Title : right. 最长公共子序列
 * Description : 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *              一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *              例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *              若这两个字符串没有公共子序列，则返回 0。
 * link : https://leetcode-cn.com/problems/longest-common-subsequence/
 * Level : Medium
 */
public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
