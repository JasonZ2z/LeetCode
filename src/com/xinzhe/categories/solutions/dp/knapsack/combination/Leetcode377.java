package com.xinzhe.categories.solutions.dp.knapsack.combination;

/**
 * @author Xin
 * @date 2020/3/5 19:55
 * Title : 377. 组合总和 Ⅳ
 * Description : 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * link : https://leetcode-cn.com/problems/combination-sum-iv
 * Level : Medium
 */
public class Leetcode377 {
    public static void main(String[] args) {
        int[] c = {4,2,1};
        System.out.println(combinationSum4(c, 32));
    }

    //+记忆化
    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
