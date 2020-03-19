package com.xinzhe.categories.dp.exist;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/19 18:11
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
