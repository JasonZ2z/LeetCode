package com.xinzhe.categories.solutions.dfs.hard;

/**
 * @Author Xin
 * @create 2020/7/26
 * Title : 329. 矩阵中的最长递增路径
 * Description : 给定一个整数矩阵，找出最长递增路径的长度。对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * link : https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * Level : Hard
 */
public class Leetcode329 {
    int[][] path = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    int longest = 1;
    int[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(matrix, i, j);
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if(visited[i][j] != 0) return visited[i][j];
        visited[i][j] = 1;
        for (int k = 0; k < 4; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            visited[i][j] = Math.max(visited[i][j], dfs(matrix, x,y) + 1);
        }
        longest = Math.max(longest, visited[i][j]);
        return visited[i][j];
    }
}
