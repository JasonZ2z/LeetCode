package com.xinzhe.order.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/2
 * Title :
 * Description :
 * link :
 * Level :
 */
//todo
public class Leetcode_biweekly_2504 {

    public int numberWays2(List<List<Integer>> hats) {
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

    private int mod = (int) 1e9 + 7;

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
                res %= mod;
            }
        }
        dp[cur][state] = (int) res;
        return dp[cur][state];
    }
}
