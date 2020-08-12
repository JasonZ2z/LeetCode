package com.xinzhe.categories.solutions.dp.stock;

/**
 * @author Xin
 * @date 2020/3/9 19:41
 * Title : 122. 买卖股票的最佳时机 II
 * Description : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 *              注意你不能在买入股票前卖出股票。
 * link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Level : Easy
 */
public class Leetcode122 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int n = prices.length;
        // 0: un-keep
        // 1: keep
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public int maxProfit2(int[] prices){
        int res = 0;
        for (int i = 0; i < prices.length; ++i) {
            if(prices[i+1] - prices[i] > 0) {
                res += prices[i+1] - prices[i];
            }
        }
        return res;
    }
}
