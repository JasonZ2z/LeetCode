package com.xinzhe.contest.weekly.weekly179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_17901 {
    public int busyStudent(int[] s, int[] e, int time) {
        int n = s.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = s[i];
            dp[i][1] = e[i];
        }

        Arrays.sort(dp, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (time >= dp[i][0] && time <= dp[i][1]) {
                count++;
            }
        }
        return count;
    }

}
