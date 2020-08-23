package com.xinzhe.contest.biweeekly.biweekly33;

/**
 * @author Xin
 * @date 2020/8/22
 * Title :
 * Description :
 * link :
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
