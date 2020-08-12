package com.xinzhe.order.day05;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/14 21:22
 * Title : 300. 最长上升子序列
 * Description : 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * link : https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * Level : Medium
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}
