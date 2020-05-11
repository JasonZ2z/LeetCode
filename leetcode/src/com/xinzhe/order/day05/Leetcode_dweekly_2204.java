package com.xinzhe.order.day05;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title : 1388. 3n 块披萨
 * Description : 给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
 *              你挑选 任意 一块披萨。Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
 *              重复上述过程直到没有披萨剩下。每一块披萨的大小按顺时针方向由循环数组 slices 表示。
 *              请你返回你可以获得的披萨大小总和的最大值。
 * link : https://leetcode-cn.com/contest/biweekly-contest-22/problems/pizza-with-3n-slices/
 * Level : Hard
 * Comment : 24双周赛04
 * tag: dp
 */
//todo need to review
public class Leetcode_dweekly_2204 {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[][] dp = new int[n][n/3+1];
        int res = 0;
        for (int i = 0; i < n-1; ++i) {
            for (int j = 0; j < n / 3; ++j) {
                dp[i][j+1] = Math.max(i > 0 ? dp[i-1][j+1] : 0, i>=2 ? dp[i-2][j] + slices[i] : slices[i]);
            }
            res = Math.max(res, dp[i][n/3]);
        }
        dp = new int[n][n/3+1];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n / 3; ++j) {
                dp[i][j+1] = Math.max(dp[i-1][j+1], i>=2 ? dp[i-2][j] + slices[i] : slices[i]);
            }
            res = Math.max(res, dp[i][n/3]);
        }
        return res;
    }
}
