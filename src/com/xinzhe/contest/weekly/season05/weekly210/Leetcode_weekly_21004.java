package com.xinzhe.contest.weekly.season05.weekly210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/11
 * Title : 1617. 统计子树中城市之间最大距离
 * Description : 给你n个城市，编号为从1 到n。同时给你一个大小为n-1的数组edges，其中edges[i] = [ui, vi]表示城市ui和vi之间有一条双向边。
 *              题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵树。一棵子树是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。
 *              两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。对于d从1 到n-1，请你找到城市间最大距离恰好为 d的所有子树数目请你返回一个大小为n-1的数组，
 *              其中第d个元素（下标从 1 开始）是城市间 最大距离 恰好等于d的子树数目。请注意，两个城市间距离定义为它们之间需要经过的边的数目。
 * link : https://leetcode-cn.com/problems/count-subtrees-with-max-distance-between-cities
 * Level : Hard
 */
public class Leetcode_weekly_21004 {
    public static void main(String[] args) {
        Leetcode_weekly_21004 lc = new Leetcode_weekly_21004();
        int[][] arr = {{1,5},{2,3},{2,4},{2,5}};
        System.out.println(Arrays.toString(lc.countSubgraphsForEachDiameter(5, arr)));
    }
    int[][] dp;
    int[][] g;
    HashSet<Integer>[] set;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] res = new int[n-1];
        this.dp = new int[n][n];
        this.g = new int[n][n];
        this.set = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            set[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int s = edge[0] - 1;
            int e = edge[1] - 1;
            dp[s][e] = 1; dp[e][s] = 1;
            g[s][e] = 1; g[e][s] = 1;
            set[s].add(e); set[e].add(s);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                solve(i, j, -1);
            }
        }

        for (int i = 3; i < (1 << n); ++i) {
            if(Integer.bitCount(i) < 2) continue;
            int x = helper(i);
            if(x >= 0) res[x-1]++;
        }
        return res;
    }

    private int solve(int i, int j, int pre) {
        if(dp[i][j] != 0) return dp[i][j];
        int ans = 0;
        if(set[i] != null) {
            for (int x : set[i]) {
                if(x == pre) continue;
                int s2 = solve(x, j, i);
                if(s2 > 0) {
                    ans = 1 + s2;
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
        for (int j = 0; j < 16; ++j) {
            if(((i >> j) & 1) == 1) {
                list.add(j);
            }
        }
        int cnt = 0, max = -1;
        for (int j = 0; j < list.size(); j++) {
            for (int k = j+1; k < list.size(); k++) {
                cnt += g[list.get(j)][list.get(k)];
                max = Math.max(max, dp[list.get(j)][list.get(k)]);
            }
        }
        return cnt == list.size() - 1 ? max : -1;
    }
}
