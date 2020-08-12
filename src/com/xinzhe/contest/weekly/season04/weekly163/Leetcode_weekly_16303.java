package com.xinzhe.contest.weekly.season04.weekly163;

/**
 * @Author Xin
 * @create 2020/6/16
 * Title : 1262. 可被三整除的最大和
 * Description : 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * link : https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * Level : Medium
 * Comment 163周赛03
 */

public class Leetcode_weekly_16303 {
    public static void main(String[] args) {
        int[] grid = {3,6,5,1,8};
        System.out.println(maxSumDivThree(grid));
    }
    public static int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][3];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int tmp = nums[i-1] % 3;
            if(tmp == 0) {
                dp[i][0] = dp[i-1][0] + nums[i];
                dp[i][1] = dp[i-1][1] + nums[i];
                dp[i][2] = dp[i-1][2] + nums[i];
            } else if(tmp == 1) {
                dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1]);
                dp[i][2] = Math.max(dp[i-1][1] + nums[i], dp[i-1][2]);
                dp[i][0] = Math.max(dp[i-1][2] + nums[i], dp[i-1][0]);
            } else {
                dp[i][2] = Math.max(dp[i-1][0] + nums[i], dp[i-1][2]);
                dp[i][0] = Math.max(dp[i-1][1] + nums[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][2] + nums[i], dp[i-1][1]);
            }
        }
        return dp[n][0];
    }
}
