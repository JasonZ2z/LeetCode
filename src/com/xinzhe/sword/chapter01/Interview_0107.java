package com.xinzhe.sword.chapter01;


/**
 * @author Xin
 * @date 2020/6/10
 * Title : 01.07. Rotate Matrix LCCI
 * Description : Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes,
 *              write a method to rotate the image by 90 degrees. Can you do this in place?
 * link : https://leetcode-cn.com/problems/rotate-matrix-lcci
 * Level : Easy
 */
public class Interview_0107 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int[] m : matrix) {
            for (int i = 0; i < n / 2; ++i) {
                int tmp = m[i];
                m[i] = m[n - i - 1];
                m[n - i - 1] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println((char) 2);
    }
}
