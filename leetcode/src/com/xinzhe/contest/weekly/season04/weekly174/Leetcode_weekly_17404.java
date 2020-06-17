package com.xinzhe.contest.weekly.season04.weekly174;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Xin
 * @create 2020/5/20
 * Title : 1340. 跳跃游戏 V
 * Description : 给你一个整数数组 arr 和一个整数 d 。每一步你可以从下标 i 跳到：
 *              i + x ，其中 i + x < arr.length 且 0 < x <= d 。
 *              i - x ，其中 i - x >= 0 且 0 < x <= d 。
 *              除此以外，你从下标 i 跳到下标 j 需要满足：arr[i] > arr[j] 且 arr[i] > arr[k] ，其中下标 k 是所有 i 到 j 之间的数字（更正式的，min(i, j) < k < max(i, j)）。
 *              你可以选择数组的任意下标开始跳跃。请你返回你 最多 可以访问多少个下标。请注意，任何时刻你都不能跳到数组的外面。
 * link : https://leetcode-cn.com/problems/jump-game-v
 * Level : Hard
 * Comment 174周赛04
 */

public class Leetcode_weekly_17404 {
    public static void main(String[] args) {
        Leetcode_weekly_17404 lc = new Leetcode_weekly_17404();
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        System.out.println(lc.maxJumps(arr, 2));
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = i;
            dp[i][1] = arr[i];
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        Arrays.sort(dp, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            int index = dp[i][0];
            for (int j = 1; index - j >= 0 && j <= d; ++j) {
                if (arr[index - j] >= arr[index]) break;
                res[index] = Math.max(res[index], res[index - j] + 1);

            }
            for (int j = 1; index + j < n && j <= d; ++j) {
                if (arr[index + j] >= arr[index]) break;
                res[index] = Math.max(res[index], res[index + j] + 1);

            }
        }
        System.out.println(Arrays.toString(res));
        return Arrays.stream(res).max().getAsInt();
    }
}
