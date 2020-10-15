package com.xinzhe.order.day13;

/**
 * @author Xin
 * @date 2020/5/8
 * Title : 221. 最大正方形
 * Description : 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * link : https://leetcode-cn.com/problems/maximal-square/
 * Level : Medium
 */

public class Leetcode221 {
    public static void main(String[] args) {
        char[][] matrix ={{'1'}};
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; if(m == 0) return 0;
        int n = matrix[0].length; if(n == 0) return 0;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max * max;
    }
}
