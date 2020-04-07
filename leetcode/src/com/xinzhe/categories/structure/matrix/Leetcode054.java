package com.xinzhe.categories.structure.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/4/7 13:56
 * Title : 54. 螺旋矩阵
 * Description : 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * link : https://leetcode-cn.com/problems/spiral-matrix/
 * Level : Medium
 */

//todo need to review
public class Leetcode054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        int count = (Math.min(m,n) + 1)/2;
        int i = 0;
        while (i < count){
            for (int j = i; j < n-i; ++j) {
                res.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; ++j) {
                res.add(matrix[j][n-1-i]);
            }
            for(int j = n-1-(i+1); j >= i && m-1-i != i; --j) {
                res.add(matrix[m-1-i][j]);
            }
            for(int j = m-1-i-1; j >= i+1 && n-1-i != i; --j) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res;
    }

    public int[] spiralOrder2(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int x1 = 0, x2 = m-1, y1 = 0, y2 = n-1;
        int index = 0;
        while (index < m*n){
            for (int i = y1; i <= y2; ++i) {
                res[index++] = matrix[x1][i];
            }
            x1++;
            if(index < m*n) {
                for (int i = x1; i <= x2; ++i) {
                    res[index++] = matrix[i][y2];
                }
                y2--;
            }
            if(index < m*n)
            {for(int i = y2; i >= y1; --i) {
                res[index++] = matrix[x2][i];
            }
            x2--;}
            if(index < m*n)
            {for(int i = x2; i >= x1; --i) {
                res[index++] =matrix[i][y1];
            }
            y1++;}
        }
        return res;
    }

}
