package com.xinzhe.categories.dp.robber;

/**
 * @Author Xin
 * @create 2020/3/13 18:33
 * Title : 213. 打家劫舍 II
 * Description : 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *              如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *              这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * link : https://leetcode-cn.com/problems/house-robber-ii/
 * Level : Medium
 */
public class Leetcode213 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,4};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        if(nums.length == 0) return  0;
        if(nums.length == 1) return  nums[0];
        int n = nums.length;
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }

    private static int helper(int[] nums, int start, int end) {
        int[][] dp = new int[end - start + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[start];

        for (int i = 1; i <= end - start; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i + start];
        }
        return Math.max(dp[end - start][0], dp[end - start][1]);
    }
}
