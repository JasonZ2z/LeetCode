package com.xinzhe.contest.weekly.season03.weekly133;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/10
 * Title : 1029. 两地调度
 * Description : 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * link : https://leetcode-cn.com/problems/two-city-scheduling
 * Level : Medium
 */

public class Leetcode_weekly_13301 {
    public static void main(String[] args) {
        Leetcode_weekly_13301 lc = new Leetcode_weekly_13301();
    }
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int sum = Arrays.stream(costs).mapToInt(a -> a[0]).sum();
        Arrays.sort(costs, (a, b) -> b[0] - b[1] - (a[0] - a[1]));
        for (int i = 0; i < n / 2; ++i) {
            sum += costs[i][1] - costs[i][0];
        }
        return sum;
    }
}
