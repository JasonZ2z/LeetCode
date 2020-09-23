package com.xinzhe.contest.weekly.season03.weekly126;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1000. 合并石头的最低成本
 * Description : 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 *              找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-cost-to-merge-stones
 * Level : Hard
 * tag : 区间dp
 */
//todo need to review
public class Leetcode_weekly_12604 {
    public static void main(String[] args) {
        Leetcode_weekly_12604 lc = new Leetcode_weekly_12604();
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
    }
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n-1) % (k-1) != 0) return -1;
        int inf = (int)1e9;
        int[][][] dp = new int[n][n][k+1];
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i-1] + stones[i-1];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], inf);
            }
            dp[i][i][1] = 0;
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                for (int l = 2; l <= k; ++l) {
                    for (int m = i; m < j; m += k - 1) {
                        dp[i][j][l] = Math.min(dp[i][j][l], dp[i][m][1] + dp[m + 1][j][l-1]);
                    }
                }
                dp[i][j][1] = dp[i][j][k] + sum[j + 1] - sum[i];
            }
        }
        return dp[0][n-1][1];
    }
}
