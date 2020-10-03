package com.xinzhe.categories.solutions.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/6/30
 * Title : 934. 最短的桥
 * Description : 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *              现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * link : https://leetcode-cn.com/problems/shortest-bridge
 * Level : Medium
 */

public class Leetcode934 {
    public static void main(String[] args) {
        Leetcode934 lc = new Leetcode934();
    }

    int[][] path = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    Queue<int[]> queue;
    int m,n;
    public int shortestBridge(int[][] a) {
        this.m = a.length;
        this.n = a[0].length;
        this.queue = new LinkedList<>();
        boolean find = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(a[i][j] == 1) {
                    dfs(a, i, j);
                    find = true;
                    break;
                }
            }
            if(find) break;
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; ++k) {
                    int x = cur[0] + path[k][0];
                    int y = cur[1] + path[k][1];
                    if(x < 0 || x >= m || y < 0 || y >= n || a[x][y] == 2 ) continue;
                    if(a[x][y] == 1) return res;
                    queue.offer(new int[]{x, y});
                    a[x][y] = 2;
                }
            }

        }
        return -1;
    }

    private void dfs(int[][] a, int i, int j) {
        a[i][j] = 2;
        queue.offer(new int[]{i,j});
        for (int k = 0; k < 4; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= m || y < 0 || y >= n || a[x][y] != 1) continue;
            dfs(a, x, y);
        }
    }
}
