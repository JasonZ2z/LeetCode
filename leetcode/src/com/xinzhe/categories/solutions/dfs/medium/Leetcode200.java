package com.xinzhe.categories.solutions.dfs.medium;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/4/3 17:53
 * Title : 200. 岛屿数量
 * Description : 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * link : https://leetcode-cn.com/problems/number-of-islands
 * Level : medium
 */

public class Leetcode200 {
    public static void main(String[] args) {
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int[][] directions = {{1,0,-1,0},
                              {0,1,0,-1}};
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                   stack.add(new int[]{i,j});
                }

            }
        }
        boolean[][] used = new boolean[m][n];
        int count = 2;
        while (!stack.isEmpty()){
            int[] cur = stack.pop();
            int x = cur[0];
            int y = cur[1];
            if(used[x][y]){
                continue;
            } else {
                used[x][y] = true;
            }
            for (int k = 0; k < 4; ++k) {
                int newX = x + directions[0][k];
                int newY = y + directions[1][k];
                if (newX >= m  || newX < 0 || newY >= n  || newY < 0 || grid[newX][newY] != 1) {
                    continue;
                }
                stack.add(new int[]{newX, newY});
            }
        }
        return count;
    }
}
