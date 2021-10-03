package com.xinzhe.contest.biweeekly.s2.biweekly62;

/**
 * @author Xin
 * @date 2021/10/02
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6201 {
    public static void main(String[] args) {
        Leetcode_biweekly_6201 lc = new Leetcode_biweekly_6201();

    }
    public int[][] construct2DArray(int[] original, int m, int n) {
        int x = original.length;
        if(x != m * n) return new int[][]{};

        int[][] res = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = original[k++];
            }
        }
        return res;
    }
}