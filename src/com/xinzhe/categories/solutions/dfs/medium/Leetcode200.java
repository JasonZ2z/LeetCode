package com.xinzhe.categories.solutions.dfs.medium;

/**
 * @author Xin
 * @date 2020/4/3 17:53
 * Title : 200. 岛屿数量
 * Description : 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * link : https://leetcode-cn.com/problems/number-of-islands
 * Level : medium
 */

public class Leetcode200 {
    public static void main(String[] args) {
    }
    int[][] directions = {{1,0,-1,0},
            {0,1,0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i,j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        for (int k = 0; k < 4; ++k) {
            int newX = x + directions[0][k];
            int newY = y + directions[1][k];
            if (newX >= grid.length || newX < 0 || newY >= grid[0].length || newY < 0 || grid[newX][newY] != '1') {
                continue;
            }
            dfs(newX, newY, grid);
        }
    }
}
