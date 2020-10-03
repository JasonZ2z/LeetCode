package com.xinzhe.contest.weekly.season05.weekly204;

/**
 * @author Xin
 * @date 2020/8/30
 * Title : 1567. 乘积为正数的最长子数组长度
 * Description : 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *              一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *              请你返回乘积为正数的最长子数组长度。
 * link : https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
 * Level : Medium
 * tag : dp
 */
public class Leetcode_weekly_20402 {
    public static void main(String[] args) {
        Leetcode_weekly_20402 lc = new Leetcode_weekly_20402();
        int[] arr = {1,2,3,5,-6,4,0,10};
        System.out.println(lc.getMaxLen(arr));
    }
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        if(nums[0] > 0) {
            dp[0][0] = 1;
        } else if(nums[0] < 0){
            dp[0][1] = 1;
        }
        int max = dp[0][0];
        for (int i = 1; i < n; ++i) {
            if(nums[i] > 0) {
                dp[i][0] = dp[i-1][0] + 1;
                if(dp[i-1][1] > 0) dp[i][1] = dp[i-1][1] + 1;
            } else if(nums[i] < 0) {
                dp[i][1] = dp[i-1][0] + 1;
                if(dp[i-1][1] > 0) dp[i][0] = dp[i-1][1] + 1;
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
