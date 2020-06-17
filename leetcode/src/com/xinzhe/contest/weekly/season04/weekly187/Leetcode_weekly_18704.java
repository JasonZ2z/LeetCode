package com.xinzhe.contest.weekly.season04.weekly187;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/3
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18704 {
    public static void main(String[] args) {
        int[][] mat = {{}};

    }
    //todo
    public static int kthSmallest(int[][] mat, int k) {
        reverse(mat);
        Arrays.sort(mat);
        int m = mat.length;
        int n = mat[0].length;
        int min = Arrays.stream(mat[0]).sum();
        return 0;

    }

    public static void reverse(int[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp[i].length; j++) {
                int k = temp[i][j];
                temp[i][j] = temp[j][i];
                temp[j][i] = k;
            }
        }
    }
}
