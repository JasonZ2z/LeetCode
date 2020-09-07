package com.xinzhe.contest.biweeekly.biweekly34;

/**
 * @author Xin
 * @date 2020/9/5
 * Title : 1572. 矩阵对角线元素的和
 * Description : 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * link : https://leetcode-cn.com/problems/matrix-diagonal-sum/
 * Level : Easy
 */
public class Leetcode_biweekly_3401 {
    public static void main(String[] args) {
        Leetcode_biweekly_3401 lc = new Leetcode_biweekly_3401();
    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int res = 0;
        if(n % 2 == 0) {
            for (int i = 0; i < n; ++i) {
                res += mat[i][i] + mat[i][n-i-1];
            }
        } else {
            for (int i = 0; i < n; ++i) {
                res += mat[i][i] + mat[i][n-i-1];
            }
            res -= mat[n/2][n/2];
        }
        return res;
    }
}
