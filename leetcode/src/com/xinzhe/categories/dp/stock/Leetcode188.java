/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.xinzhe.categories.dp.stock;

/**
 * @Author Xin
 * @create 2020/3/9 20:12
 * Title : 188. 买卖股票的最佳时机 IV
 * Description : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              设计一个算法来计算你所能获取的最大利润。你最多可以完成 K笔 交易。
 *              注意你不能在买入股票前卖出股票。
 * link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Level : Hard
 */
public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2) return 0;
        int n = prices.length;
        if(k >= n/2) {
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            }
            return dp[n-1][0];
        } else {
            int[][][] dp = new int[n][k+1][2];
            for (int i = 0; i < n ; i++) {
                for (int j = 1; j < k+1; j++) {
                    if(i==0){
                        dp[0][j][0] = 0;
                        dp[0][j][1] = -prices[0];
                    } else {
                        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                    }

                }

            }
            return dp[n-1][k][0];
        }

    }
}
