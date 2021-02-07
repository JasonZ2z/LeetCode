package com.xinzhe.contest.biweeekly.biweekly45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Xin
 * @date 2021/02/05
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4504 {
    public static void main(String[] args) {
        Leetcode_biweekly_4504 lc = new Leetcode_biweekly_4504();
        int[] arr = {2, 4, 9, 3};
    }
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int[][] dp = new int[n][k + 1];
        int[] prev = new int[n];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (events[j][1] < events[i][0]) {
                    prev[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                max = Math.max(max, dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0,
                        (prev[i] == -1 ? 0 : dp[prev[i]][j - 1]) + events[i][2]));
            }
        }
        return max;
    }
}