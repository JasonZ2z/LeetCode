package com.xinzhe.contest.weekly.season04.weekly162;

/**
 * @author Xin
 * @date 2020/6/17
 * Title : 1254. 统计封闭岛屿的数目
 * Description : 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 *              我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 *              如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。请返回封闭岛屿的数目
 * link : https://leetcode-cn.com/problems/number-of-closed-islands
 * Level : Medium
 * Comment 162周赛03
 */

public class Leetcode_weekly_16203 {
    int res = 0;
    int[][] grid;
    boolean[][] visited;
    int[][] dir = {{1,0},{0,1},{-1, 0}, {0,-1}};
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];

        for (int i = 1; i < m-1; ++i) {
            for (int j = 1; j < n-1; ++j) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    if(helper(i, j))
                        res++;
                }
            }
        }
        return res;
    }

    private boolean helper(int i, int j) {
        boolean flag = true;
        visited[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1 || visited[x][y]) continue;
            if(x == 0 || x == m-1 || y == 0 || y == n-1) {
                flag = false;
            }else {
                flag |= helper(x, y);
            }
        }
        return flag;
    }
}
