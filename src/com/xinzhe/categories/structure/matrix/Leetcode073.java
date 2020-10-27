package com.xinzhe.categories.structure.matrix;

/**
 * @author Xin
 * @date 2020/4/2 18:39
 * Title : 73. 矩阵置零
 * Description : 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * link : https://leetcode-cn.com/problems/set-matrix-zeroes/
 * Level : Medium
 */

public class Leetcode073 {
    //空间复杂度 O(2) ，
    // 1. 用两个布尔变量记录首行首列是否有零。
    // 2. 第一次遍历，从数组下标的 A[1][1] 开始，为零则用首行和首列来记录 0 值。
    // 3. 第二次遍历，从数组下标的 A[1][1] 开始遍历，根据首行首列改变元素值，
    // 4. 最后判断首行首列是否需要置0。
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean preY = false;
        boolean preX = false;
        for (int i = 0; i < m; ++i) {
            if(matrix[i][0] == 0){
                preY = true;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            if(matrix[0][i] == 0){
                preX = true;
                break;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(preX){
            for (int i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }
        if(preY){
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
