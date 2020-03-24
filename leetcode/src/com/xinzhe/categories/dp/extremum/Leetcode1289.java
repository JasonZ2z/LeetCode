package com.xinzhe.categories.dp.extremum;

/**
 * @Author Xin
 * @create 2020/3/24 19:01
 * Title : 1289. 下降路径最小和  II
 * Description : 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *               请你返回非零偏移下降路径数字和的最小值。
 * link : https://leetcode-cn.com/problems/minimum-falling-path-sum-ii
 * Level : Hard
 */
public class Leetcode1289 {

    public int minFallingPathSum2(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];
        dp[0] = arr[0];
        int min1, min2;
        int j1=-1, j2 = -1;
        for (int i = 1; i < m; ++i) {
            min1 = min2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                if(dp[i-1][j] < min1){
                    min2 = min1;
                    j2 = j1;
                    min1 = dp[i-1][j];
                    j1 = j;
                } else {
                   if(dp[i-1][j] < min2){
                       min2 = dp[i-1][j];
                       j2 = j;
                   }
                }
            }
            for (int j = 0; j < n; ++j) {
                if(j != j1){
                    dp[i][j] = dp[i-1][j1] + arr[i][j];
                } else {
                    dp[i][j] = dp[i-1][j2] + arr[i][j];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            res = Math.min(res, dp[m-1][i]);
        }
        return res;
    }


    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if(n == 0) return 0;
        if(n==1) return arr[0][0];

        int[][] dp = new int[m][n];
        dp[0] = arr[0];
        for (int i = 1; i < m; i++) {
            // get two min values of the previous row
            int preMinIndex = getMinValue(dp[i - 1], -1);
            int preNextMinIndex = getMinValue(dp[i - 1], preMinIndex);
            for (int j = 0; j < n; j++) {
                if(j != preMinIndex){
                    dp[i][j] = dp[i-1][preMinIndex] + arr[i][j];
                } else {
                    dp[i][j] = dp[i-1][preNextMinIndex] + arr[i][j];
                }
            }
        }
        int min = getMinValue(dp[m-1], -1);
        return dp[m-1][min];

    }

    private int getMinValue(int[] arr, int index){
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < arr.length; i++)
            if (i != index && min > arr[i]) {
                min = arr[i];
                res = i;
            }
        return res;
    }
}
