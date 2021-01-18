package com.xinzhe.contest.weekly.season05.weekly224;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/01/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22403 {
    public static void main(String[] args) {
        Leetcode_weekly_22403 lc = new Leetcode_weekly_22403();
        int[] arr = {3,5};
    }

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cnt = new int[m + 1][n];

        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(matrix[i-1][j] == 0) cnt[i][j] = 0;
                else {
                    cnt[i][j] = cnt[i-1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < cnt.length; i++) {
            Arrays.sort(cnt[i]);
            for (int j = cnt[i].length - 1; j >= 0 && cnt[i][j] > 0; j--) {
                max = Math.max(max, cnt[i][j] * (n - j));
            }
        }
        return max;
    }
}
