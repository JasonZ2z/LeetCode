package com.xinzhe.categories.solutions.dp.jumpgame;

/**
 * @author Xin
 * @date 2020/3/13 18:43
 * Title : 55. 跳跃游戏
 * Description :  给定一个非负整数数组，你最初位于数组的第一个位置。
 *               数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *               判断你是否能够到达最后一个位置
 * link : https://leetcode-cn.com/problems/jump-game/
 * Level : Medium
 */
public class Leetcode055 {
    //dp
    public boolean canJump(int[] nums) {
        if(nums.length < 1) return false;

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = nums[j] + j >= i && dp[j];
                if(dp[i])break;
            }
            dp[i] = false;

        }
        return dp[n-1];
    }

    //greedy
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        if(n <= 1) return true;
        for(int i=0; i<n-1; i++) {
            if(nums[i] == 0) {
                boolean flag = false;
                for(int j =i-1; j>= 0; j--) {
                    if(j + nums[j] > i) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) return false;
            }
        }
        return true;
    }
}
