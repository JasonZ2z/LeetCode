package com.xinzhe.contest.weekly.season04.weekly157;

/**
 * @Author Xin
 * @create 2020/7/16
 * Title : 1219. 黄金矿工
 * Description :  m * n 的网格 grid, 每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。了使收益最大化，矿工需要按以下规则来开采黄金：
 *          每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 *          矿工每次可以从当前位置向上下左右四个方向走。
 *          每个单元格只能被开采（进入）一次。
 *          不得开采（进入）黄金数目为 0 的单元格。
 *          矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 * link : https://leetcode-cn.com/problems/path-with-maximum-gold
 * Level : Medium
 * Comment 157周赛03
 * tag : dfs， 回溯
 */

//todo dfs need to review
public class Leetcode_weekly_15703 {

    public static void main(String[] args) {
        Leetcode_weekly_15703 lc = new Leetcode_weekly_15703();
        int[][] arr = {{34,0,1,0,0,0},
                        {0,0,2,0,1,0},
                        {5,4,3,7,4,2},
                        {0,0,5,0,1,4},
                        {0,0,5,0,2,3}};

        System.out.println(lc.getMaximumGold(arr));
    }

    int[][] path = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    boolean[][] visited;
    int res = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited =  new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(grid, i, j, grid[i][j]);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, int max) {
        res = Math.max(res, max);
        for (int k = 0; k < 4; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y]) continue;
            visited[x][y] = true;
            dfs(grid, x, y, max + grid[x][y]);
            visited[x][y] = false;
        }
    }

    // 不开visited数组
    public int getMaximumGold2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] != 0) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int old = grid[i][j];
        grid[i][j] = 0;
        int tmp = 0;
        for (int k = 0; k < 4; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 ) continue;
            tmp = Math.max(tmp, dfs(grid, x, y));
        }
        tmp += old;
        grid[i][j] = old;
        return tmp;
    }
}
