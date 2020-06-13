package com.xinzhe.interview.chapter01.medium;


import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/6/11
 * Title : 01.08. Zero Matrix LCCI
 * Description : Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * link : https://leetcode-cn.com/problems/zero-matrix-lcci
 */
public class Interview_0108 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer i : row) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : col) {
            for (int i = 0; i < m; ++i) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((char) 2);
    }
}
