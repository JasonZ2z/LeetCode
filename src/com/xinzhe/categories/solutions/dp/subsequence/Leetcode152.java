package com.xinzhe.categories.solutions.dp.subsequence;

/**
 * @author Xin
 * @date 2020/3/9 21:44
 * Title : 152. 乘积最大子序列
 * Description : 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * link : https://leetcode-cn.com/problems/maximum-product-subarray/
 * Level : Medium
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        if(nums.length < 1) return 0;
        int n = nums.length;
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] < 0){
                int tmp = dpmin[i-1];
                dpmin[i-1] = dpmax[i-1];
                dpmax[i-1] = tmp;
            }
            dpmax[i] = Math.max(dpmax[i-1]*nums[i], nums[i]);
            dpmin[i] = Math.min(dpmin[i-1]*nums[i], nums[i]);
            max = Math.max(dpmax[i], max);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        long res = dp[0][0];
        for(int i=1; i<n; i++) {
            if(nums[i] > 0) {
                dp[i][0] = Math.max(dp[i-1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i-1][1] * nums[i], nums[i]);
            } else if(nums[i] < 0){
                dp[i][0] = dp[i-1][1] * nums[i];
                dp[i][1] = Math.min(dp[i-1][0] * nums[i], nums[i]);
            }
            res = Math.max(res, dp[i][0]);
        }
        return (int)res;

    }

    public int maxProduct3(int[] nums) {
        int n = nums.length;
        long ans = nums[0], max = nums[0], min = nums[0];
        for(int i=1; i<n; i++) {
            if(nums[i] < 0) {
                long tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return (int)ans;
    }
}
