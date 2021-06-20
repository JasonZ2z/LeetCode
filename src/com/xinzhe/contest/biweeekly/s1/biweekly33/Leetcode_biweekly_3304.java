package com.xinzhe.contest.biweeekly.s1.biweekly33;

/**
 * @author Xin
 * @date 2020/8/22
 * Title : 1559. 二维网格图中探测环
 * Description : 给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
 *              一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
 *              同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
 *              如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
 * link : https://leetcode-cn.com/problems/detect-cycles-in-2d-grid
 * Level : Hard
 */
public class Leetcode_biweekly_3304 {
    public static void main(String[] args) {
        Leetcode_biweekly_3304 lc = new Leetcode_biweekly_3304();
        char[][] arr ={{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        System.out.println(lc.containsCycle(arr));
    }
    int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 1 || n == 1) return false;
        int[][] used = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(dfs(grid, used, i,j, 1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int[][] used, int i, int j, int steps) {
        if(used[i][j] != 0) {
            return steps - used[i][j] > 3;
        }
        used[i][j] = steps;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != grid[i][j]) continue;
            if(dfs(grid, used, x, y, steps+1)){
                return true;
            }
        }
        return false;
    }
}
