package com.xinzhe.categories.solutions.dp.stock;

/**
 * @Author Xin
 * @create 2020/3/9 19:51
 * Title : 123. 买卖股票的最佳时机 III
 * Description : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *              注意你不能在买入股票前卖出股票。
 * link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Level : Hard
 */
public class Leetcode123 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                if(i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                } else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                }

            }
        }
        return dp[n-1][2][0];
    }
}
