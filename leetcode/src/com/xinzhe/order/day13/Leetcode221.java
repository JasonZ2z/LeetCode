package com.xinzhe.order.day13;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/8
 * Title : 221. 最大正方形
 * Description : 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * link : https://leetcode-cn.com/problems/maximal-square/
 * Level : Medium
 */

public class Leetcode221 {
    public static void main(String[] args) {
        char[][] matrix ={{'1'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int m  = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int res = 0;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; ++i) {
            if(matrix[i][0] == '1') {
                flag = true;
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            if(matrix[0][i] == '1') {
                flag = true;
                dp[0][i] = 1;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int upleft = dp[i-1][j-1];
                    if(up == 0 || left == 0 || upleft == 0) {
                        dp[i][j] = 1;
                    } else if(up == left && left == upleft){
                        dp[i][j] = up+1;
                    } else {
                        dp[i][j] = Math.min(left, Math.min(up, upleft)) + 1;
                    }
                }
                res = Math.max(res, dp[i][j]);

            }
        }
        if(res == 0 && flag) return 1;
        return res;
    }
}
