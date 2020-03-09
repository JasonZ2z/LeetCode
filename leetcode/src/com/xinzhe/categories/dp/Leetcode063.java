package com.xinzhe.categories.dp;

/**
 * @Author Xin
 * @create 2020/3/9 18:21
 * Title : 63. 不同路径 II
 * Description : 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *              机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *              现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * link : https://leetcode-cn.com/problems/unique-paths-ii/
 * Level : Medium
 */
public class Leetcode063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        boolean mf = false;
        boolean nf = false;
        for (int i = 0; i < m; i++) {
            if(mf){
                dp[i][0] = 0;
            } else {
                if(obstacleGrid[i][0] == 1){
                    mf = true;
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(nf){
                dp[0][i] = 0;
            } else {
                if(obstacleGrid[0][i] == 1) {
                    nf = true;
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }
        return dp[m-1][n-1];
    }
}
