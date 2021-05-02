package com.xinzhe.contest.weekly.season05.weekly235;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23503 {
    public static void main(String[] args) {
        Leetcode_weekly_23503 lc = new Leetcode_weekly_23503();
        int[] arr = {0,1,2,3,0};
        System.out.println(lc.minSideJumps(arr));

    }

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][4];
        for (int i = 1; i < n; ++i) {
            if(obstacles[i] == 0) {
                for (int j = 1; j < 4; ++j) {
                    dp[i][j] = dp[i-1][j];
                }
            } else {
                dp[i][obstacles[i]] = dp[i-1][obstacles[i]] + 1;
                for (int j = 1; j < 4; ++j) {
                    if(j != obstacles[i]) {
                        dp[i][j] = Math.min(dp[i][obstacles[i]], dp[i-1][j]) + 1;
                    }
                }
            }
        }
        return Math.min(dp[n-1][1], Math.min(dp[n-1][2], dp[n-1][3]));
    }
}
