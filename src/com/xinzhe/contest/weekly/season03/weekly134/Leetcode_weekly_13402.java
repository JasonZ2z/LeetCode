package com.xinzhe.contest.weekly.season03.weekly134;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/10
 * Title : 1034. 边框着色
 * Description : 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 *              只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 *              连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 *              给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid 。
 * link : https://leetcode-cn.com/problems/coloring-a-border
 * Level : Medium
 */

public class Leetcode_weekly_13402 {
    public static void main(String[] args) {
        Leetcode_weekly_13402 lc = new Leetcode_weekly_13402();
        int[][] arr = {{1,1} ,{1,2}};
        System.out.println(Arrays.deepToString(lc.colorBorder(arr, 0, 0, 3)));
    }
    int[][] paths = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    boolean[][] used;
    int[][] res;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        this.used = new boolean[m][n];
        this.res = new int[m][n];
        bfs(grid, r0, c0, color, grid[r0][c0]);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(res[i][j] == 0) res[i][j] = grid[i][j];
            }
        }
        return res;
    }

    private void bfs(int[][] grid, int i, int j, int color, int pre) {
        used[i][j] = true;
        for (int[] path : paths) {
            int x = i + path[0];
            int y = j + path[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || used[x][y]) continue;
            if(grid[x][y] == pre) {
                bfs(grid, x, y, color, grid[i][j]);
            } else {
                res[i][j] = color;
            }
        }
        if(grid[i][j] == pre && (i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1)) {
            res[i][j] = color;
        }
    }

}
