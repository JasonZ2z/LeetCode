package com.xinzhe.contest.nowcoder.s1.s109;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author Xin
 * @create 2020/8/7
 * Title : Portal
 * Description :游戏是在一个N*N的网格图中进行的，图中的网格分为四种类型，0表示空地可以通过，1表示墙壁无法通过，
 * 2表示不仅可以通过，还可以在该格放置一个传送门， 3表示有且仅有的唯一的固定传送门。
 * 在游戏开始时，牛牛可以选择一块2类型的格子放置传送门并且不可以中途更改，
 * 在游戏过程中，如果到达其中一个传送门，则可以传送往另一个传送门。游戏的起点始终为左上角，终点始终为右下角，牛牛每次可以往四个方向移动，即上下左右四个方向。
 * 牛牛想知道从起点走到终点最少需要走几步（使用传送门也算作一步）。
 * link : https://ac.nowcoder.com/acm/contest/6781/B
 * Level : Hard
 * tag : 双向BFS
 */
//todo need to review
public class nowcoder_0903 {
    /**
     * 返回最终要输出的答案
     * @param n int整型 表示地图的大小
     * @param a int整型二维数组 地图的描述
     * @return int整型
     */
    public int solve (int n, int[][] a) {
        // write code here
        int[][] fromStart = dist(a, 0,0);
        int[][] fromEnd = dist(a, n-1,n-1);
        int x = -1, y = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(a[i][j] == 3){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int ans = fromStart[n-1][n-1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(a[i][j] == 2) {
                    ans = Math.min(fromStart[i][j] + fromEnd[x][y] + 1, ans);
                    ans = Math.min(fromStart[x][y] + fromEnd[i][j] + 1, ans);
                }
            }
        }
        return ans;

    }
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    public int[][] dist(int[][] a, int x, int y) {
        int n = a.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[x][y] = 0;
        Deque<int[]> queue = new ArrayDeque<>(n*n);
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            int curX = cur[0], curY = cur[1];
            for (int[] dir : dirs) {
                int nx = curX + dir[0];
                int ny = curY + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || a[nx][ny] == 1) continue;
                int newDist = dist[curX][curY] + 1;
                if(dist[nx][ny] > newDist) {
                    dist[nx][ny] = newDist;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
}
