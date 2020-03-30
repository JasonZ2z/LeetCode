package com.xinzhe.categories.solutions.bfs;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/3/30 16:34
 * Title : 994. 腐烂的橘子
 * Description : 在给定的网格中，每个单元格可以有以下三个值之一：
 *              值 0 代表空单元格；
 *              值 1 代表新鲜橘子；
 *              值 2 代表腐烂的橘子。
 *              每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *              返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * link : https://leetcode-cn.com/problems/rotting-oranges
 * Level : Easy
 */

public class Leetcode994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {0,1,1},{1,0,1}};
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        if(m == 0) return -1;
        int n = grid[0].length;
        boolean flag = false;
        int[][] directions = {{1, 0, -1, 0},
                                {0, 1, 0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    flag = true;
                }
            }
        }
        if(!flag) return 0;
        int res = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int i = 0; i < 4; ++i) {
                    int newX = x + directions[0][i];
                    int newY = y + directions[1][i];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 2) continue;
                    if(grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                    }

                }
            }
            res++;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }
}
