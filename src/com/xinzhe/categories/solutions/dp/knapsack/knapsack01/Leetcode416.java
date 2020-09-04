package com.xinzhe.categories.solutions.dp.knapsack.knapsack01;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/19 18:11
 * Title : 416. 分割等和子集
 * Description : 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * link : https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * Level : Medium
 */

public class Leetcode416 {
    public static void main(String[] args) {
        int[] nums =  {23,13,11,7,6,5,5};
        System.out.println(canPartition(nums));
    }
    //入门版本
    public static boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int sub = sum >> 1;
        boolean[][] dp = new boolean[n][sub+1];
        for(int i=0; i<n; i++) dp[i][0]= true;

        if(nums[0] <= sub) {
            dp[0][nums[0]] = true;
        } else {
            return false;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= sub; ++j) {
                dp[i][j] = dp[i - 1][j];
                if(j <= nums[i])  dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - nums[i]]);
            }
        }
        return dp[n-1][sub];
    }

    //降维压缩空间
    public static boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;
        int sub = sum >> 1;
        boolean[] dp = new boolean[sub + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sub; i >= num ; i--) {
                if(dp[i-num]){
                    dp[i] = true;
                }
            }
        }
        return dp[sub];
    }
}
