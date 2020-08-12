package com.xinzhe.contest.weekly.season04.weekly153;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/7/29
 * Title : 1187. 使数组严格递增
 * Description : 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 *              每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。如果无法让 arr1 严格递增，请返回 -1。
 * link : https://leetcode-cn.com/problems/make-array-strictly-increasing
 * Level :
 */
//todo too hard to solve
public class Leetcode_weekly_15304 {

    public static void main(String[] args) {
        Leetcode_weekly_15304 lc = new Leetcode_weekly_15304();
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        arr2 = Arrays.stream(arr2).distinct().sorted().toArray();
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m][n + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = arr1[i - 1] < arr1[i] ? Math.min(dp[i - 1][0], dp[i][0]) : dp[i][0];
            for (int t = 0; t < n && arr2[t] < arr1[i]; t++) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][t + 1]);
            }
            for (int j = n - 1; j >= 1; j--) {
                dp[i][j] = arr2[j - 1] > arr1[i - 1] ? Math.min(dp[i - 1][0] + 1, dp[i][j]) : dp[i][j];
                dp[i][j] = j > 1 && dp[i - 1][j - 1] < Integer.MAX_VALUE / 2 ? Math.min(dp[i - 1][j - 1] + 1, dp[i][j]) : dp[i][j];
                if (dp[i][j] >= Integer.MAX_VALUE / 2) {
                    break;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[m - 1][i]);
        }

        return result >= Integer.MAX_VALUE / 2 ? -1 : result;
    }
}
