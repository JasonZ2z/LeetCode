package com.xinzhe.categories.solutions.dp.extremum;

/**
 * @author Xin
 * @date 2020/3/18 19:01
 * Title : 931. 下降路径最小和
 * Description : 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * link : https://leetcode-cn.com/problems/minimum-falling-path-sum/
 * Level : Medium
 */
public class Leetcode931 {
    public static void main(String[] args) {
        int[][] a ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(minFallingPathSum(a));
    }
    public static int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        if(n == 0) return 0;

        int[][] dp = new int[m][n];
        System.arraycopy(A[0], 0, dp[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0) dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + A[i][j];
                else if(j == n-1) dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + A[i][j];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]) , dp[i-1][j+1]) + A[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m-1][i]);
        }
        return min;
    }
}
