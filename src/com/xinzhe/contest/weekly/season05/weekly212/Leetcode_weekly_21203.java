package com.xinzhe.contest.weekly.season05.weekly212;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/10/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21203 {
    public static void main(String[] args) {
        Leetcode_weekly_21203 lc = new Leetcode_weekly_21203();
        int[][] arr = {{1,10,6,7,9,10,4,9}};
        System.out.println(lc.minimumEffortPath(arr));
    }
    int[][] paths = {{1,0}, {0,1}, {-1,0}, {0,-1}};

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
}
