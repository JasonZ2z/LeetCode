package com.xinzhe.contest.weekly.season05.weekly220;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/12/20
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22003 {
    public static void main(String[] args) {
        Leetcode_weekly_22003 lc = new Leetcode_weekly_22003();
        int[] arr = {1,-1,-2,4,-7,3};
        System.out.println(lc.maxResult(arr, 2));
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            for (int j = i-1; j >=0 && i - j <= k ; j--) {
                if(nums[j] >= 0) {
                    dp[i] = dp[j];
                    break;
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += nums[i];
        }
        return dp[n-1];
    }
}
