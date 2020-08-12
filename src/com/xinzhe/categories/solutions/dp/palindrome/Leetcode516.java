package com.xinzhe.categories.solutions.dp.palindrome;

/**
 * @author Xin
 * @date 2020/3/10 18:35
 * Title : 516. 最长回文子序列
 * Description : 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * link : https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * Level : Medium
 */
public class Leetcode516 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() ==1 )return 1;
        int n = s.length();
        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] =1;
//        }
        int max =1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[j][i] = dp[j+1][i-1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
                }

            }
        }
        return dp[0][n-1];
    }
}
