package com.xinzhe.contest.biweeekly.s2.biweekly61;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/09/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6103 {
    public static void main(String[] args) {
        Leetcode_biweekly_6103 lc = new Leetcode_biweekly_6103();
        int[][] arr = {{9,10,2},{4,5,6},{6,8,1},{1,5,5},{4,9,5},{1,6,5},{4,8,3},{4,7,10},{1,9,8},{2,3,5}};
        System.out.println(lc.maxTaxiEarnings(10, arr));

    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        for (int[] ride : rides) {
            ride[2] += ride[1] - ride[0];
        }
        Arrays.sort(rides, (a, b) -> a[1] == b[1] ? (a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]) : a[1] - b[1]);
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 0L;
        long max = 0L;
        for (int[] ride : rides) {
            int y = ride[1], v = ride[2];
            dp[y] = max;
            for (int j = ride[0]; j >= 1; --j) {
                if (dp[j] != -1){
                    dp[y] = Math.max(dp[y], dp[j] + v);
                    break;
                }
            }

            max = Math.max(max, dp[y]);
        }
        return max;
    }

}