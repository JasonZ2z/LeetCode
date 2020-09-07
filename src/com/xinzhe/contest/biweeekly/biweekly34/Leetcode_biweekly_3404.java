package com.xinzhe.contest.biweeekly.biweekly34;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/5
 * Title : 1575. 统计所有可行路径
 * Description : 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 *              每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
 *              请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
 *              请你返回从 start 到 finish 所有可能路径的数目,由于答案可能很大， 请将它对 10^9 + 7 取余后返回。
 * link : https://leetcode-cn.com/problems/count-all-possible-routes
 * Level : Hard
 * tag : dp + 记忆化
 */
//todo need to review
public class Leetcode_biweekly_3404 {
    private static final int MOD = (int)1e9 + 7;
    public static void main(String[] args) {
        Leetcode_biweekly_3404 lc = new Leetcode_biweekly_3404();
    }
    long[][] dp;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        this.dp = new long[n][fuel + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        dfs(locations, start, finish, fuel);
        return (int)dp[start][fuel];
    }

    private long dfs(int[] locations, int start, int finish, int fuel) {
        if(dp[start][fuel] != -1) return dp[start][fuel];
        long ans = 0;
        if(start == finish) ans++;
        for (int i = 0; i < locations.length; i++) {
            int cost = Math.abs(locations[i] - locations[start]);
            if(i != start && fuel >= cost) {
                ans += dfs(locations, i, finish, fuel - cost);
            }
        }
        dp[start][fuel] = ans % MOD;
        return dp[start][fuel];
    }
}
