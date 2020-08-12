package com.xinzhe.order.day09;

/**
 * @author Xin
 * @date 2020/4/7 14:53
 * Title : 面试题 01.07. 旋转矩阵
 * Description : 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。不占用额外内存空间能否做到？
 * link : https://leetcode-cn.com/problems/rotate-image/
 * Level : Medium
 */

public class Interview_107 {
    //转圈
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        for (int i = 0, e = n - 1; i < e; i++, e--) {
            for (int j = i; j < e; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[e - (j - i)][i];
                matrix[e - (j - i)][i] = matrix[e][e - (j - i)];
                matrix[e][e - (j - i)] = matrix[j][e];
                matrix[j][e] = tmp;
            }
        }
    }
    //转置+翻转
    public void rotate2(int[][] matrix){
        int n = matrix.length;
        if(n == 0) return;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i+1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =  tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
