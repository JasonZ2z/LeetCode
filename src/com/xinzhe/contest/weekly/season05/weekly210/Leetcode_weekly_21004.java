package com.xinzhe.contest.weekly.season05.weekly210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/11
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21004 {
    public static void main(String[] args) {
        Leetcode_weekly_21004 lc = new Leetcode_weekly_21004();
        int[][] arr = {{1,2},{2,3},{2,4}};
        System.out.println(Arrays.toString(lc.countSubgraphsForEachDiameter(4, arr)));
    }
    int[][] dp;
    HashSet<Integer>[] set;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] res = new int[n-1];
        this.dp = new int[n][n];
        this.set = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            set[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int s = edge[0] - 1;
            int e = edge[1] - 1;
            dp[s][e] = 1;
            dp[e][s] = 1;
            set[s].add(e);
            set[e].add(s);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                solve(i, j);
            }
        }

        for (int i = 3; i < (1 << n); ++i) {
            if(Integer.bitCount(i) < 2) continue;
            int x = helper(i);
            if(x >= 0) res[x-1]++;
        }
        return res;
    }

    private int solve(int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        int ans = 0;
       // used[i] = true;
        if(set[i] != null) {
            for (int x : set[i]) {
                //if(used[x]) continue;
                int s1 = solve(i, x);
                int s2 = solve(x, j);
                if(s1 > 0 && s2 > 0) {
                    ans = s1 + s2;
                    break;
                }
            }
        }
        dp[i][j] = ans;
        dp[j][i] = ans;
        return ans;
    }

    private int helper(int i) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 32; ++j) {
            if(((i >> j) & 1) == 1) {
                list.add(j);
            }
        }
        int max = -1;
        for (int j = 0; j < list.size(); j++) {
            for (int k = j+1; k < list.size(); k++) {
                max = Math.max(max, dp[list.get(j)][list.get(k)]);
            }
        }
        return max;
    }
}
