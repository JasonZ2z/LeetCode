package com.xinzhe.contest.weekly.season03.weekly121;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 983. 最低票价
 * Description : 你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。火车票有三种不同的销售方式：
 *              一张为期一天的通行证售价为 costs[0] 美元；
 *              一张为期七天的通行证售价为 costs[1] 美元；
 *              一张为期三十天的通行证售价为 costs[2] 美元。
 *              通行证允许数天无限制的旅行。返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * link : https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * Level : Medium
 */

public class Leetcode_weekly_12103 {
    public static void main(String[] args) {
        Leetcode_weekly_12103 lc = new Leetcode_weekly_12103();
        int[] arr = {1,4,6,7,8,20};
        int[] cost = {7,2,15};
        System.out.println(lc.minCostTickets(arr, cost));
    }
    public int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> set = Arrays.stream(days).boxed().collect(Collectors.toSet());
        for (int i = 1; i < 366; i++) {
            if(set.contains(i)) {
                int num1 = dp[i-1] + costs[0];
                int num7 = i > 7 ? dp[i-7] + costs[1] : costs[1];
                int num30 = i > 30 ? dp[i-30] + costs[2] : costs[2];
                dp[i] = Math.min(num1, Math.min(num7, num30));
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[365];
    }
}
