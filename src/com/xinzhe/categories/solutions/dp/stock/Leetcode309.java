package com.xinzhe.categories.solutions.dp.stock;

/**
 * @Author Xin
 * @create 2020/3/9 20:22
 * Title : 309. 最佳买卖股票时机含冷冻期
 * Description : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 *              你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *              卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * Level : Medium
 */
public class Leetcode309 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = prices[1] > prices[0] ? (prices[1] - prices[0]) : 0;
        dp[1][1] = Math.max(-prices[1], -prices[0]);
        for (int i = 2; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
