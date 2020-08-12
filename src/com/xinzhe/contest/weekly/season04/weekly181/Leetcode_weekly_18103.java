package com.xinzhe.contest.weekly.season04.weekly181;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/5/5
 * Title : 1391. 检查网格中是否存在有效路径
 * Description : 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 *          1 表示连接左单元格和右单元格的街道。
 *          2 表示连接上单元格和下单元格的街道。
 *          3 表示连接左单元格和下单元格的街道。
 *          4 表示连接右单元格和下单元格的街道。
 *          5 表示连接左单元格和上单元格的街道。
 *          6 表示连接右单元格和上单元格的街道
 * link : https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
 * Level : Medium
 * Comment : 181周赛03
 */
public class Leetcode_weekly_18103 {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 上下左右
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == m-1 && cur[1] == n-1) return true;
            int way = 1;
            int before = grid[cur[0]][cur[1]];
            for (int[] direction : directions) {
                int x = cur[0] + direction[0];
                int y = cur[1] + direction[1];
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                int after = grid[x][y];
                if(helper(before, after, way)) {
                    queue.offer(new int[]{x,y});
                    visited[x][y] = true;
                    break;
                }
                way++;
            }
        }
        return false;
    }

    private boolean helper(int before, int after, int way) {
        // way 代表 1， 2， 3， 4
        // 分别代表 上 下 左 右
        if(way == 1) {
            return (before == 2 || before == 5 || before == 6) && (after == 2 || after == 3 || after == 4);
        } else if(way == 2) {
            return (before == 2 || before == 3 || before == 4) && (after == 2 || after == 6 || after == 5);
        } else if(way == 3) {
            return (before == 1 || before == 5 || before == 3) && (after == 1 || after == 4 || after == 6);
        } else if(way == 4) {
            return (before == 1 || before == 4 || before == 6) && (after == 1 || after == 3 || after == 5);
        }
        return false;
    }

}
