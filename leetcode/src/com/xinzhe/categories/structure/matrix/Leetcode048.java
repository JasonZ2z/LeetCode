package com.xinzhe.categories.structure.matrix;

/**
 * @author Xin
 * @date 2020/4/7 15:53
 * Title : 48. 旋转图像
 * Description : 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。不占用额外内存空间能否做到？
 * link : https://leetcode-cn.com/problems/rotate-image/
 * Level : Medium
 */

public class Leetcode048 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return;

        for (int i = 0; i < m-1; ++i) {
            for (int j = i+1; j < m; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < (m + 1) / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1 -j];
                matrix[i][m-1 -j] = tmp;
            }
        }

    }
}
