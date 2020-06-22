package com.xinzhe.interview.chapter01;

/**
 * @Author Xin
 * @create 2020/6/10
 * Title : 01.05. One Away LCCI
 * Description : There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
 *              Given two strings, write a function to check if they are one edit (or zero edits) away.
 * link : https://leetcode-cn.com/problems/one-away-lcci
 * Level : Easy
 */
public class Interview_0105 {

    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        int[][] dp = new int[firstLen + 1][secondLen + 1];
        for (int j = 1; j <= secondLen; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= firstLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= firstLen; i++) {
            for (int j = 1; j <= secondLen; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[firstLen][secondLen] <= 1;

    }

    public static void main(String[] args) {
        System.out.println((char) 2);
    }
}
