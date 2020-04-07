package com.xinzhe.categories.structure.matrix;

/**
 * @author Xin
 * @date 2020/4/7 14:56
 * Title : 59. 螺旋矩阵 II
 * Description : 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * link : https://leetcode-cn.com/problems/spiral-matrix-ii/
 * Level : Medium
 */

public class Leetcode059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x1 = 0;
        int x2 = n-1;
        int y1 = 0;
        int y2 = n-1;
        int c = 1;
        while (c <= n * n){
            for (int i = x1; i <= x2; ++i) {
                res[y1][i] = c++;
            }
            y1++;
            for (int i = y1; i <= y2; ++i) {
                res[i][x2] = c++;
            }
            x2--;
            for(int i = x2; i >= x1; --i) {
                res[y2][i] = c++;
            }
            y2--;
            for(int i = y2; i >= y1; --i) {
                res[i][x1] = c++;
            }
            x1++;
        }
        return res;
    }
}
