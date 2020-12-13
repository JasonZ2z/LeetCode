package com.xinzhe.contest.weekly.season05.weekly219;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/12/13
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_21903 {
    public static void main(String[] args) {
        Leetcode_weekly_21903 lc = new Leetcode_weekly_21903();
        int[] arr = {5,3,1,4,2};
        System.out.println(lc.stoneGameVII(arr));
    }

    Integer[][] dp;
    int[] stones;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        this.stones = stones;
        int sum = Arrays.stream(stones).sum();
        this.dp = new Integer[n][n];
        return solve(0, n-1, sum);
    }

    private int solve(int i, int j, int sum) {
        if(i == j) return 0;
        int res = 0;
        if(i < j) {
            if(dp[i][j] != null) return dp[i][j];
            res = Math.max(res, sum - stones[j] - solve(i, j-1, sum - stones[j]));
            res = Math.max(res, sum - stones[i] - solve(i+1, j, sum - stones[i]));
            dp[i][j] = res;
        }
        return res;
    }
}
