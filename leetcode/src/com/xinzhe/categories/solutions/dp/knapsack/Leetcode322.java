package com.xinzhe.categories.solutions.dp.knapsack;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/19 18:21
 * Title : 322. 零钱兑换
 * Description : 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * link : https://leetcode-cn.com/problems/coin-change/
 * Level : Medium
 */

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i > coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin]+1);
                } else if (i == coin) {
                    dp[i] = 1;
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
