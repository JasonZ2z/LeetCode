package com.xinzhe.contest.weekly.season05.weekly207;

/**
 * @author Xin
 * @date 2020/9/20
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20703 {
    public static void main(String[] args) {
        Leetcode_weekly_20703 lc = new Leetcode_weekly_20703();
        int[][] arr = {{1,-2,1},{1,-2,1},{3,-4,1}};
        //int[][] arr = {{1,3}, {0,-4}};
        System.out.println(lc.maxProductPath(arr));
    }

    final int Mod = (int)1e9 + 7;


    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][] max = new long[n][m];
        long[][] min = new long[n][m];
        max[0][0] = min[0][0] = 1L * grid[0][0];
        for(int i = 1; i < n; i++) max[i][0] = min[i][0] = max[i - 1][0] * grid[i][0];
        for(int i = 1; i < m; i++) max[0][i] = min[0][i] = max[0][i - 1] * grid[0][i];
        for(int i = 1; i < n; i++)
            for(int j = 1; j < m; j++)
            {
                max[i][j] = Math.max( Math.max(max[i - 1][j] , min[i - 1][j] * grid[i][j]) , Math.max(max[i][j - 1] * grid[i][j], min[i][j - 1] * grid[i][j]));
                min[i][j] = Math.min( Math.min(max[i - 1][j] * grid[i][j], min[i - 1][j] * grid[i][j]) , Math.min(max[i][j - 1] * grid[i][j], min[i][j - 1] * grid[i][j]));
            }
        if(max[n - 1][m - 1] < 0) return -1;
        return (int) (max[n - 1][m - 1] % 1000000007);
    }
}
