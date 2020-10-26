package com.xinzhe.contest.weekly.season05.weekly212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/10/25
 * Title : 1631. 最小体力消耗路径
 * Description : 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
 *              一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *              一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。请你返回从左上角走到右下角的最小 体力消耗值 。
 * link : https://leetcode-cn.com/problems/path-with-minimum-effort
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_21203 {
    public static void main(String[] args) {
        Leetcode_weekly_21203 lc = new Leetcode_weekly_21203();
        int[][] arr = {{1,10,6,7,9,10,4,9}};
        System.out.println(lc.minimumEffortPath(arr));
    }
    int[][] paths = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    // O(n) : m*n*log(m*n)
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        queue.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            if (visited[i][j]) continue;
            visited[i][j] = true;
            if (i == m - 1 && j == n - 1) return cur[2];
            for (int[] path : paths) {
                int x = i + path[0];
                int y = j + path[1];
                if(x < 0 || x >= m || y< 0 || y >= n) continue;
                int abs = Math.max(cur[2], Math.abs(heights[i][j] - heights[x][y]));
                queue.offer(new int[]{x, y, abs});
            }
        }
        return -1;
    }

    // O(n) : m*n*log(1e6)
    int[][] heights;
    int m, n;
    boolean[][] used;
    public int minimumEffortPath2(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        this.used = new boolean[m][n];
        int l = 0, r = (int)1e6;
        while(l < r) {
            int mid = (l + r) >> 1;
            for(int i = 0; i < m; i++) Arrays.fill(used[i], false);
            dfs(0, 0, heights[0][0], mid);
            if(used[m-1][n-1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private void dfs(int i, int j, int pre, int target) {
        if(Math.abs(heights[i][j] - pre) > target) return;
        used[i][j] = true;
        for(int[] path : paths) {
            int x = i + path[0];
            int y = j + path[1];
            if(x < 0 || x >= m || y < 0 || y >= n || used[x][y]) continue;
            dfs(x , y, heights[i][j], target);
        }
    }
}
