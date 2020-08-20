package com.xinzhe.contest.weekly.season03.weekly141;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/8/20
 * Title : 1091. 二进制矩阵中的最短路径
 * Description :
 * link : https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 * Level : Medium
 */

public class Leetcode_weekly_14103 {
    public static void main(String[] args) {
        Leetcode_weekly_14103 lc = new Leetcode_weekly_14103();
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        int[][] dirs = {{1,0}, {1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        int[][] visited = new int[n][n];
        for(int[] a : visited) {
            Arrays.fill(a, n*n);
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y= cur[1], step=cur[2];
            if(x == n-1 && y == n-1) return step;
            if(step >= visited[x][y]) continue;
            visited[x][y] = step;
            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != 0) continue;
                queue.add(new int[]{nx, ny, step+1});
            }
        }
        return -1;
    }
}
