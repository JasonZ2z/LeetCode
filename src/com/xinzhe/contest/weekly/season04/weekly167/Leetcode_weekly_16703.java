package com.xinzhe.contest.weekly.season04.weekly167;

/**
 * @author Xin
 * @date 2020/6/03
 * Title : 1292. 元素和小于等于阈值的正方形的最大边长
 * Description : 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * link : https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 * Level : Medium
 * Comment 167周赛03
 */

public class Leetcode_weekly_16703 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] pre = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) pre[i][j] = mat[i][j];
                else pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + mat[i][j] - pre[i - 1][j - 1];
            }
        }

        int k = Math.min(m, n);

        for (; k >= 1; --k) {
            for (int i = m - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    if (j >= k && i >= k) {
                        if (pre[i][j] - pre[i][j - k] - pre[i - k][j] + pre[i - k][j - k] <= threshold) return k;
                    }
                }
            }
        }
        return 0;
    }

}
