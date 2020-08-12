package com.xinzhe.contest.biweeekly.biweekly25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/2
 * Title : 1434. 每个人戴不同帽子的方案数
 * Description : 总共有 n 个人和 40 种不同的帽子，帽子编号从 1 到 40 。
 *              给你一个整数列表的列表 hats ，其中 hats[i] 是第 i 个人所有喜欢帽子的列表。
 *              请你给每个人安排一顶他喜欢的帽子，确保每个人戴的帽子跟别人都不一样，并返回方案数。
 *              由于答案可能很大，请返回它对 10^9 + 7 取余后的结果。
 * link : https://leetcode-cn.com/problems/number-of-ways-to-wear-different-hats-to-each-other
 * Level : Hard
 */
//todo need to review
public class Leetcode_biweekly_2504 {

    public int numberWays(List<List<Integer>> hats) {
        List<Integer>[] adj = new List[41];
        for (int i = 0; i < 41; i++) {
            adj[i] = new ArrayList<>();
        }
        int n = hats.size();
        for (int i = 0; i < n; i++) {
            for (int j : hats.get(i)) {
                adj[j].add(i);
            }
        }
        Integer[][] dp = new Integer[41][1 << n];
        return dfs(adj, n, dp, 0, 0);
    }

    static final int MOD = (int) 1e9 + 7;

    private int dfs(List<Integer>[] adj, int n, Integer[][] dp, int cur, int state) {
        if (state == (1 << n) - 1) {
            return 1;
        }
        if (cur == 41) {
            return 0;
        }
        if (dp[cur][state] != null) {
            return dp[cur][state];
        }
        long res = dfs(adj, n, dp, cur + 1, state);
        for (int next : adj[cur]) {
            if ((state & (1 << next)) == 0) {
                res += dfs(adj, n, dp, cur + 1, state | (1 << next));
                res %= MOD;
            }
        }
        dp[cur][state] = (int) res;
        return dp[cur][state];
    }
}
