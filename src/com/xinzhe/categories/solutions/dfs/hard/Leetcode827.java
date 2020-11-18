package com.xinzhe.categories.solutions.dfs.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/11/17
 * Title : 827. 最大人工岛
 * Description : 在二维地图上，0代表海洋，1代表陆地，我们最多只能将一格0 海洋变成1变成陆地。进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的1可形成岛屿）
 * link : https://leetcode-cn.com/problems/making-a-large-island
 * Level : Hard
 */

//todo need to review
//dfs + 染色法
public class Leetcode827 {
    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,0}};
        Leetcode827 lc = new Leetcode827();
        System.out.println(lc.largestIsland(arr));
    }
    Map<Integer, Integer> map = new HashMap<>();
    int[][] paths = {{1,0},{0,1},{-1,0}, {0,-1}};
    int m, n;
    int max;
    private boolean valid(int i, int j) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }

    private int dfs(int[][] grid, int i, int j, int color) {
        int ans = 1;
        grid[i][j] = color;
        for(int k=0; k<4; k++) {
            int x = i + paths[k][0];
            int y = j + paths[k][1];
            if(valid(x, y) || grid[x][y] != 1) continue;
            ans += dfs(grid, x , y, color);
        }
        return ans;
    }

    public int largestIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int color = 2;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int cnt = dfs(grid, i, j, color);
                    max = Math.max(max, cnt);
                    map.put(color, cnt);
                    color++;
                }
            }
        }
        if(max == m * n) return max;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    max = Math.max(max, count(grid, i, j));
                }
            }
        }
        return max;
    }

    private int count(int[][] grid, int i, int j) {
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for(int k=0; k<4; k++) {
            int x = i + paths[k][0];
            int y = j + paths[k][1];
            if(valid(x, y) || grid[x][y] == 0) continue;
            set.add(grid[x][y]);
        }
        for (Integer col : set) {
            ans += map.get(col);
        }
        return ans;
    }
}
