package com.xinzhe.categories.solutions.dp.robber;

/**
 * @author Xin
 * @date 2020/3/13 18:23
 * Title : 198. 打家劫舍
 * Description : 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *              如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * link : https://leetcode-cn.com/problems/house-robber
 * Level : Easy
 */
public class Leetcode198 {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        if(nums.length == 0) return  0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
