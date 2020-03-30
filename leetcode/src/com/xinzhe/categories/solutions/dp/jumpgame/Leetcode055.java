package com.xinzhe.categories.solutions.dp.jumpgame;

/**
 * @Author Xin
 * @create 2020/3/13 18:43
 * Title : 55. 跳跃游戏
 * Description :  给定一个非负整数数组，你最初位于数组的第一个位置。
 *               数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *               判断你是否能够到达最后一个位置
 * link : https://leetcode-cn.com/problems/jump-game/
 * Level : Medium
 */
public class Leetcode055 {
    public boolean canJump(int[] nums) {
        if(nums.length < 1) return false;

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = nums[j] + j >= nums[j] && dp[j];
                if(dp[i])break;
            }
            dp[i] = false;

        }
        return dp[n-1];
    }
}
