package com.xinzhe.categories.solutions.greedy.easy;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/25
 * Title : 1029. 两地调度
 * Description : 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * link : https://leetcode-cn.com/problems/two-city-scheduling
 * Level : Easy
 */
public class Leetcode1029 {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        Arrays.sort(costs, (a, b) -> b[0] - b[1] - (a[0] - a[1]));
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            sum += costs[i][1] + costs[i + n][0] - costs[i + n][1];
        }
        return sum;
    }
}
