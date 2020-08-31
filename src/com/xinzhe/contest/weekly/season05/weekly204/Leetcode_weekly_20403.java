package com.xinzhe.contest.weekly.season05.weekly204;

/**
 * @author Xin
 * @date 2020/8/30
 * Title : 1568. 使陆地分离的最少天数
 * Description : 给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。
 *              如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。
 *              一天内，可以将任何单个陆地单元（1）更改为水单元（0）。返回使陆地分离的最少天数。
 * link : https://leetcode-cn.com/problems/minimum-number-of-days-to-disconnect-island
 * Level : Medium
 * tag : greedy
 */
public class Leetcode_weekly_20403 {
    public static void main(String[] args) {
        Leetcode_weekly_20403 lc = new Leetcode_weekly_20403();
    }
    int[][] dirs = {{1,0}, {0,1} , {-1, 0}, {0, -1}};
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(check(grid)) return 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(check(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private boolean check(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    dfs(grid, used, i, j);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1 && !used[i][j]) {
                    res++;
                }
                if(res == 1) return true;
            }
        }
        return false;
    }

    private void dfs(int[][] grid, boolean[][] used, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || used[i][j]) return;
        used[i][j] = true;
        for(int[] dir : dirs) {
            dfs(grid, used, i+dir[0], j+dir[1]);
        }
    }
}
