package com.xinzhe.contest.weekly.season05.weekly244;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/06/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24401 {
    public static void main(String[] args) {
        Leetcode_weekly_24401 lc = new Leetcode_weekly_24401();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] tar = {{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(lc.findRotation(mat, tar));
    }

    private int n;
    public boolean findRotation(int[][] mat, int[][] target) {
        this.n = mat.length;
        if(check(mat, target)) return true;
        mat = adjust(mat);
        if(check(mat, target)) return true;
        mat = adjust(mat);
        if(check(mat, target)) return true;
        mat = adjust(mat);
        return check(mat, target);
    }

    private boolean check(int[][] mat, int[][] target) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

    private int[][] adjust(int[][] mat) {
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int  tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(mat));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n/2; ++j) {
                int tmp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n-j-1] = tmp;
            }
        }
        System.out.println(Arrays.deepToString(mat));
        return mat;
    }

}
