package com.xinzhe.order.day07;

/**
 * @author Xin
 * @date 2020/3/25 19:01
 * Title : 892. 三维形体的表面积
 * Description : 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *              每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上
 *              请你返回最终形体的表面积。
 * link : https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * Level : Easy
 */

public class Leetcode892 {
    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{1, 0, -1, 0},
                        {0, 1, 0, -1}};
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = grid[i][j];
                if(v > 0){
                    res += 2;
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dir[0][k];
                        int y = j + dir[1][k];
                        int w = 0;
                        if(x >= 0 && x < m && y >= 0 && y < n){
                            w = grid[x][y];

                        }
                        if(v > w){
                            res += v-w;
                        }
                    }
                }
            }
        }
        return res;
    }

}
