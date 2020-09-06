package com.xinzhe.contest.biweeekly.biweekly34;

/**
 * @author Xin
 * @date 2020/9/5
 * Title :
 * Description :
 * link :
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
