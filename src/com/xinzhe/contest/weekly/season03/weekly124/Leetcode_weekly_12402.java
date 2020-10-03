package com.xinzhe.contest.weekly.season03.weekly124;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 994. 腐烂的橘子
 * Description : 在给定的网格中，每个单元格可以有以下三个值之一：值 0 代表空单元格；值 1 代表新鲜橘子；值 2 代表腐烂的橘子。
 *              每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * link : https://leetcode-cn.com/problems/rotting-oranges
 * Level : Medium
 */

public class Leetcode_weekly_12402 {
    public static void main(String[] args) {
        Leetcode_weekly_12402 lc = new Leetcode_weekly_12402();
        int[] arr = {2,-3,-1,5,-4};
    }
    public int orangesRotting(int[][] grid) {
        int[][] paths = {{1,0}, {0,1}, {0,-1}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1) flag = false;
            }
        }
        if(flag) return 0;
        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] path : paths) {
                    int x = cur[0] + path[0];
                    int y = cur[1] + path[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    if(grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}
