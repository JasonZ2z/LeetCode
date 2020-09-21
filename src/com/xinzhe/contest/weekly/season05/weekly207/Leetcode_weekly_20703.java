package com.xinzhe.contest.weekly.season05.weekly207;

/**
 * @author Xin
 * @date 2020/9/20
 * Title : 1594. 矩阵的最大非负积
 * Description : 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 *              在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 *              返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。注意，取余是在得到最大积之后执行的。
 * link : https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix
 * Level : Medium
 */

//todo need to review
public class Leetcode_weekly_20703 {
    public static void main(String[] args) {
        Leetcode_weekly_20703 lc = new Leetcode_weekly_20703();
    }
    static final int MOD = (int)1e9 + 7;
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) max[0][0] = min[0][0] = grid[0][0];
                else if(i == 0) max[i][j] = min[i][j] = max[i][j-1] * grid[i][j];
                else if(j == 0) max[i][j] = min[i][j] = max[i-1][j] * grid[i][j];
                else {
                    max[i][j] = Math.max(Math.max(max[i-1][j] * grid[i][j], max[i][j-1] * grid[i][j]), Math.max(min[i-1][j] * grid[i][j], min[i][j-1] * grid[i][j]));
                    min[i][j] = Math.min(Math.min(max[i-1][j] * grid[i][j], max[i][j-1] * grid[i][j]), Math.min(min[i-1][j] * grid[i][j], min[i][j-1] * grid[i][j]));
                }
            }
        }
        return max[m-1][n-1] < 0 ? -1 : (int)(max[m-1][n-1] % MOD);
    }
}
