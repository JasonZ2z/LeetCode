package com.xinzhe.categories.solutions.dp.stock;

/**
 * @author Xin
 * @date 2020/3/9 20:32
 * Title : 714. 买卖股票的最佳时机含手续费
 * Description : 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *              你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *              返回获得利润的最大值。
 * link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * Level : Medium
 */
public class Leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2) return 0;
        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
