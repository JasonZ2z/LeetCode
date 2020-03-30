package com.xinzhe.categories.solutions.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/3/29 19:49
 * Title : 1162. 地图分析
 * Description : 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *              我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *              如果我们的地图上只有陆地或者海洋，请返回 -1。
 * link : https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * Level : Medium
 */
public class Leetcode1162 {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        if(m == 0) return -1;
        int n = grid[0].length;

        int[][] directions = {{1,0,-1,0},
                                {0,1,0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(queue.size() == 0 || queue.size() == m*n){
            return -1;
        }
        int res = -1;
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; ++j) {
                    int newX = x + directions[0][j];
                    int newY = y + directions[1][j];
                    if(newX >= m || newX < 0 || newY >= n || newY < 0 || grid[newX][newY] != 0){
                        continue;
                    }
                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX, newY});
                }
            }

        }
        return res;
    }
}
