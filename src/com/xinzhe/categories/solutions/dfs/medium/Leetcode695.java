package com.xinzhe.categories.solutions.dfs.medium;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/3/15 11:33
 * Title : 695. 岛屿的最大面积
 * Description : 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *              找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * link : https://leetcode-cn.com/problems/max-area-of-island/
 * Level : Medium
 */
public class Leetcode695 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},
                        {1,1,1,1,0},
                        {0,0,0,1,1},
                        {0,0,0,1,1}};
        //System.out.println(maxAreaOfIsland(grid));
        System.out.println(maxAreaOfIsland2(grid));
    }

    public static int maxAreaOfIsland2(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i,j), max);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int x, int y) {

        if(x < 0 || x>= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return 0;
        grid[x][y] = 0;
        return 1 + dfs(grid, x+1, y) + dfs(grid, x-1, y) + dfs(grid, x, y+1) + dfs(grid, x, y-1);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max_area = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    stack.add(new int[]{i,j});
                    int cur = 0;
                    while(!stack.isEmpty()){
                        int[] inner = stack.pop();
                        int x = inner[0];
                        int y = inner[1];
                        if(x < 0 || x>= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                        cur++;
                        grid[x][y] = 0;
                        for (int k = 0; k < 4; k++) {
                            int newX = x + d[k][0];
                            int newY = y + d[k][1];
                            stack.add(new int[]{newX, newY});
                        }
                    }
                    max_area = Math.max(max_area, cur);

                }
            }
        return max_area;
    }
    int[][] d = {{1,0,-1,0},
                 {0,1,0,-1}};
    public int maxAreaOfIsland3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1){
                    res = Math.max(dfs2(i,j, grid), res);
                }
            }
        }

        return res;
    }

    private int dfs2(int i, int j, int[][] grid) {
        int count = 1;
        grid[i][j] = 0;
        for (int k = 0; k < 4; ++k) {
            int x = i + d[0][k];
            int y = j + d[1][k];
            if(x < 0 || x>= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) continue;
            count += dfs2(x,y,grid);
        }
        return count;
    }
}
