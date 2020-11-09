package com.xinzhe.contest.weekly.season05.weekly214;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/08
 * Title : 1648. 销售价值减少的颜色球
 * Description : 你有一些球的库存inventory，里面包含着不同颜色的球。一个顾客想要任意颜色 总数为orders的球。
 *              这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的同色球的数目。比方说还剩下6个黄球，那么顾客买第一个黄球的时候该黄球的价值为6。这笔交易以后，只剩下5个黄球了，所以下一个黄球的价值为5（也就是球的价值随着顾客购买同色球是递减的）
 *              给你整数数组inventory，其中inventory[i]表示第i种颜色球一开始的数目。同时给你整数orders，表示顾客总共想买的球数目。你可以按照 任意顺序卖球。
 *              请你返回卖了 orders个球以后 最大总价值之和。由于答案可能会很大，请你返回答案对 109+ 7取余数的结果。
 * link : https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_21403 {
    public static void main(String[] args) {
        Leetcode_weekly_21403 lc = new Leetcode_weekly_21403();
        int[] arr = {497978859,167261111,483575207,591815159};
        System.out.println(lc.maxProfit(arr, 836556809));
    }
    static final int MOD = (int)1e9 +7;

    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        Arrays.sort(inventory);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int can = inventory[i] - (i > 0 ? inventory[i-1] : 0);
            int use = (int) Math.min(orders, (long)can * (n - i));
            long r = inventory[i];
            long l = r - use/(n - i);
            ans += (l + 1 + r) * (n - i) * (r - l)/ 2;
            ans += l * (use % (n - i));
            ans %= MOD;
            orders -= use;
        }
        return (int) ans;
    }
}
