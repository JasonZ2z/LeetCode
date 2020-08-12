package com.xinzhe.contest.weekly.season04.weekly156;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/7/17
 * Title : 1210. 穿过迷宫的最少移动次数
 * Description : 你还记得那条风靡全球的贪吃蛇吗？
 *          我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。
 *          我们用 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
 * link : https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations/
 * Level : Hard
 * Comment 156周赛04
 */

public class Leetcode_weekly_15604 {

    public static void main(String[] args) {
        Leetcode_weekly_15604 lc = new Leetcode_weekly_15604();
        int[][] arr = {{0,0,0,0,0,1}, {1,1,0,0,1,0},{0,0,0,0,1,1}, {0,0,1,0,1,0}, {0,1,1,0,0,0}, {0,1,1,0,0,0}};
        System.out.println(lc.minimumMoves(arr));
    }
    public int minimumMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        POS start = new POS(0, 1, 0, 0);
        LinkedList<POS> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            POS cur = queue.poll();
            if (cur.x == m - 1 && cur.y == n - 1 && cur.to == 0) return cur.step;
            String s = String.valueOf(cur.x) + cur.y + cur.to;
            if (visited.contains(s)) continue;
            visited.add(s);
            int newY = cur.y + 1, newX = cur.x + 1;
            if (cur.to == 0) {
                if (newY < n && grid[cur.x][newY] == 0) {
                    queue.offer(new POS(cur.x, newY, 0, cur.step + 1));
                }
                if (newX < m && grid[newX][cur.y] == 0 && grid[newX][cur.y - 1] == 0) {
                    queue.offer(new POS(newX, cur.y - 1, 1, cur.step + 1));
                    queue.offer(new POS(newX, cur.y, 0, cur.step + 1));
                }
            } else {
                if (newX < m && grid[newX][cur.y] == 0) {
                    queue.offer(new POS(newX, cur.y, 1, cur.step + 1));
                }
                if (newY < n && grid[cur.x][newY] == 0 && grid[cur.x - 1][newY] == 0) {
                    queue.offer(new POS(cur.x - 1, newY, 0, cur.step + 1));
                    queue.offer(new POS(cur.x, newY, 1, cur.step + 1));
                }
            }
        }
        return -1;
    }

    class POS {
        int x;
        int y;
        int to;
        int step;

        public POS(int x, int y, int to, int step) {
            this.x = x;
            this.y = y;
            this.to = to;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            POS pos = (POS) o;
            return x == pos.x &&
                    y == pos.y &&
                    to == pos.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, to);
        }
    }
}
