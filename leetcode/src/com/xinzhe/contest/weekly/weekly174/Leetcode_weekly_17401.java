package com.xinzhe.contest.weekly.weekly174;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Xin
 * @create 2020/5/20
 * Title : 1337. 方阵中战斗力最弱的 K 行
 * Description : 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * link : https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * Level : Easy
 * Comment 174周赛01
 */

public class Leetcode_weekly_17401 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][2];
        for (int i = 0; i < m; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) count++;
            }
            dp[i][0] = i;
            dp[i][1] = count;
        }

        Arrays.sort(dp, Comparator.comparingInt(a -> a[1]));
        int[] res = new int[k];

        for (int i = 0; i < k; ++i) {
            res[i] = dp[i][0];
        }
        return res;
    }
}
