package com.xinzhe.contest.weekly.season05.weekly208;

/**
 * @author Xin
 * @date 2020/9/27
 * Title : 1599. 经营摩天轮的最大利润
 * Description : 你正在经营一座摩天轮，该摩天轮共有 4 个座舱 ，每个座舱 最多可以容纳 4 位游客 。
 *              你可以 逆时针 轮转座舱，但每次轮转都需要支付一定的运行成本 runningCost 。摩天轮每次轮转都恰好转动 1 / 4 周  ...
 * link : https://leetcode-cn.com/problems/maximum-profit-of-operating-a-centennial-wheel/
 * Level : Medium
 */
public class Leetcode_weekly_20802 {
    public static void main(String[] args) {
        Leetcode_weekly_20802 lc = new Leetcode_weekly_20802();
    }
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int max = -1, index = -2, curr = 0, currSum = 0;
        for (int i = 0; i < customers.length || curr > 0; i++) {
            if (i < customers.length) {
                curr += customers[i];
            }
            currSum += Math.min(4, curr) * boardingCost - runningCost;
            curr -= Math.min(4, curr);
            if (currSum > max) {
                max = currSum;
                index = i;
            }
        }
        return index + 1;
    }
}
