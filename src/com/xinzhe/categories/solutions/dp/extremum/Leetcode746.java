package com.xinzhe.categories.solutions.dp.extremum;

/**
 * @author Xin
 * @date 2020/3/9 19:21
 * Title : 746. 使用最小花费爬楼梯
 * Description : 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *              每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *              您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * link : https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * Level : Easy
 */
public class Leetcode746 {
    public static void main(String[] args) {
        int[] cost = {1};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+ cost[i-1], dp[i-2]+ cost[i-2]);
        }
        return dp[n];
    }
}
