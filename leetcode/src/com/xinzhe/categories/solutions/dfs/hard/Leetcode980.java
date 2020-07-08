package com.xinzhe.categories.solutions.dfs.hard;

/**
 * @Author Xin
 * @create 2020/7/6
 * Title : 980. 不同路径 III
 * Description : 在二维网格 grid 上，有 4 种类型的方格：
 *          1 表示起始方格。且只有一个起始方格。
 *          2 表示结束方格，且只有一个结束方格。
 *          0 表示我们可以走过的空方格。
 *          -1 表示我们无法跨越的障碍。
 *      返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 * link : https://leetcode-cn.com/problems/unique-paths-iii
 * Level : Hard
 */

public class Leetcode980 {

    int[][] path = {{1, 0}, {0,1}, {-1, 0}, {0,-1}};

    int m,n;
    int count = 0;
    int[] start;
    int total = 0;
    boolean[][] visited;
    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        this.start = new int[]{0,0};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) start = new int[]{i,j};
                if(grid[i][j] != -1) total++;
            }
        }
        visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        dfs(grid, start[0], start[1], 1);
        return count;
    }

    private void dfs(int[][] grid, int i, int j, int steps) {
        if(grid[i][j] == 2 && steps == total) {
            count++;
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1 || visited[x][y]) continue;
            dfs(grid, x, y, steps+1);
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,2}, {0,0,-1}};
        Leetcode980 lc = new Leetcode980();
        System.out.println(lc.uniquePathsIII(arr));
    }
}
