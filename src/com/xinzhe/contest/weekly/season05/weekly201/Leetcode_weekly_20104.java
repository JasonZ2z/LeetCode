package com.xinzhe.contest.weekly.season05.weekly201;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title : 1547. 切棍子的最小成本
 * Description : 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 *              你可以按顺序完成切割，也可以根据需要更改切割的顺序。每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。
 *              对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。返回切棍子的 最小总成本 。
 * link : https://leetcode-cn.com/problems/minimum-cost-to-cut-a-stick
 * Level : Hard
 * tag : dp + memo
 */
//todo need to review
public class Leetcode_weekly_20104 {
    public static void main(String[] args) {
        Leetcode_weekly_20104 lc = new Leetcode_weekly_20104();
        int[] arr = {1,3,4,5};
        System.out.println(lc.minCost(7, arr));
    }

    int[][] dp;
    int[] arr;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 2;
        arr = new int[m];
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0,  arr, 1, cuts.length);
        arr[0] = 0; arr[m-1] = n;
        this.dp = new int[m][m];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, m-1);
    }

    private int helper(int l, int r) {
        if( r - l <= 1) return 0;
        if(dp[l][r] == -1) {
            dp[l][r] = (int)1e9;
            for (int i = l+1; i < r; ++i) {
                dp[l][r] = Math.min(dp[l][r], helper(l,i) + helper(i,r) + arr[r] - arr[l]);
            }
        }
        return dp[l][r];
    }

    //dp
    public int minCost2(int n, int[] cuts) {
        int m = cuts.length + 2;
        arr = new int[m];
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0,  arr, 1, cuts.length);
        arr[0] = 0; arr[m-1] = n;
        int[][] dp = new int[m][m];
        for (int i = 2; i < m; ++i) {
            for (int j = 0; j < m - i; ++j) {
                dp[j][j + i] = (int)1e9;
                for (int k = j + 1; k < j + i; ++k) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k][j + i] + arr[i+j] - arr[j]);
                }
            }
        }
        return dp[0][m - 1];
    }
}
