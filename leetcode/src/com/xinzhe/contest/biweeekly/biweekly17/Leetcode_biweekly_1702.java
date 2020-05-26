package com.xinzhe.contest.biweeekly.biweekly17;

/**
 * @Author Xin
 * @create 2020/5/26
 * Title : 1314. 矩阵区域和
 * Description : 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 * i - K <= r <= i + K, j - K <= c <= j + K 
 * (r, c) 在矩阵内。
 * link : https://leetcode-cn.com/problems/matrix-block-sum
 * Level : Medium
 * Comment 17双周赛02
 */

public class Leetcode_biweekly_1702 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] + mat[i][j] - preSum[i][j];
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = Math.max(i - k, 0);
                int y1 = Math.max(j - k, 0);
                int x2 = Math.min(i + k, m - 1);
                int y2 = Math.min(j + k, n - 1);
                res[i][j] = preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
            }
        }
        return res;
    }

}
