package com.xinzhe.categories.solutions.dp.stock;

/**
 * @Author Xin
 * @create 2020/3/9 19:31
 * Title : 121. 买卖股票的最佳时机
 * Description : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *              如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *              注意你不能在买入股票前卖出股票。
 * link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * Level : Easy
 */
public class Leetcode121 {

    //一次遍历，找当前最小值
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
    //暴力
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j <= n-1; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
