package com.xinzhe.contest.weekly.season05.weekly213;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21302 {
    public static void main(String[] args) {
        Leetcode_weekly_21302 lc = new Leetcode_weekly_21302();
        int[] arr = {3,5};
    }
    public int countVowelStrings(int n) {
        int[][] dp = new int[51][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= 50; ++i) {
            for(int j = 4; j >= 0; --j) {
                if(j == 4) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j+1];
            }
        }

        return dp[n][0];
    }
}
