package com.xinzhe.contest.weekly.season03.weekly132;

/**
 * @author Xin
 * @date 2020/9/10
 * Title : 1027. 最长等差数列
 * Description : 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *              回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 *              并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 * link : https://leetcode-cn.com/problems/longest-arithmetic-subsequence
 * Level : Medium
 */

public class Leetcode_weekly_13203 {
    public static void main(String[] args) {
        Leetcode_weekly_13203 lc = new Leetcode_weekly_13203();
    }
    public int longestArithSeqLength(int[] a) {
        int n = a.length;
        if(n == 2) return n;
        int[][] dp = new int[n][20001];
        int max = 1;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                int x = a[i] - a[j] + 10000;
                dp[i][x] = Math.max(dp[j][x] + 1, dp[i][x]);
                max = Math.max(max, dp[i][x]);
            }
        }
        return max+1;
    }
}
