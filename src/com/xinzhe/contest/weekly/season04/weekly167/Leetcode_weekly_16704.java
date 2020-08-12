package com.xinzhe.contest.weekly.season04.weekly167;

import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/6/03
 * Title : 1293. 网格中的最短路径
 * Description : 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 * link : https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination
 * Level : Hard
 * Comment 167周赛04
 */

public class Leetcode_weekly_16704 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0, 0, 1, 0, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {0, 0, 0, 1, 0, 0, 1, 0}};
        System.out.println(shortestPath(grid, 1));
    }

    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        LinkedList<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        queue.add(new Node(0, 0, 0, k));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.x == m - 1 && cur.y == n - 1) {
                    return cur.count;
                }
                visited[cur.x][cur.y][cur.rest] = true;
                for (int j = 0; j < 4; ++j) {
                    int newX = cur.x + dir[j][0];
                    int newY = cur.y + dir[j][1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                    if (grid[newX][newY] == 1) {
                        if (cur.rest > 0 && !visited[newX][newY][cur.rest - 1]) {
                            queue.offer(new Node(newX, newY, cur.count + 1, cur.rest - 1));
                            visited[newX][newY][cur.rest - 1] = true;
                        }
                    } else {
                        if (!visited[newX][newY][cur.rest]) {
                            queue.offer(new Node(newX, newY, cur.count + 1, cur.rest));
                            visited[newX][newY][cur.rest] = true;
                        }
                    }
                }
            }
        }


        return -1;

    }

    static class Node {
        int x;
        int y;
        int count;
        int rest;

        public Node(int x, int y, int count, int rest) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.rest = rest;
        }
    }
}
