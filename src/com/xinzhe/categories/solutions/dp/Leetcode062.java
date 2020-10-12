package com.xinzhe.categories.solutions.dp;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/9 18:21
 * Title : 62. 不同路径
 * Description : 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *              机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *              问总共有多少条不同的路径？
 * link : https://leetcode-cn.com/problems/unique-paths
 * Level : Medium
 */
public class Leetcode062 {
    public static void main(String[] args) {
        Leetcode062 lc = new Leetcode062();
        System.out.println(lc.uniquePaths2(10, 10));
        System.out.println(lc.uniquePaths3(10, 10));
    }
    //二维dp
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];

    }

    //dp 压缩空间
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
    //数学方法 组合数
    public int uniquePaths3(int m, int n) {
        return (int) combination(m + n -2, m-1);
    }

    private long combination(int n, int k) {
        long a=1, b=1;
        if(k > n/2) k = n-k;
        for(int i = 1; i <= k; i++) {
            a *= (n+1-i);
            b *= i;
        }
        return a/b;
    }
}
