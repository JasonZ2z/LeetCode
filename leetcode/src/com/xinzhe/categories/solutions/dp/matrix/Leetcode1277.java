package com.xinzhe.categories.solutions.dp.matrix;

/**
 * @Author Xin
 * @create 2020/3/26 18:55
 * Title : 1277. 统计全为 1 的正方形子矩阵
 * Description : 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * link : https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * Level : Medium
 */

public class Leetcode1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;

        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int res =0;
        for(int i=0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(matrix[i][j] == 1){
                    if( i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
