package com.xinzhe.order.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/5/13
 * Title : 1377. T 秒后青蛙的位置
 * Description : 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [fromi, toi] 意味着存在一条直接连通 fromi 和 toi 两个顶点的边。
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。
 * link : https://leetcode-cn.com/problems/frog-position-after-t-seconds
 * Level : Hard
 * Comment 179周赛04
 * tag : dfs, graph
 */

public class Leetcode_weekly_17904 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    double res = 0.0;

    //无向图 + dfs
    public double frogPosition(int n, int[][] edges, int t, int target) {
        for (int i = 1; i <= n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, target, t, 1, visited);
        return res;
    }

    private void dfs(int i, int target, int t, double sum, boolean[] visited) {
        if (t <= 0) {
            if (i == target) {
                res += sum;
            }
            return;
        }
        int count = 0;
        List<Integer> cur = map.get(i);
        if (cur == null) return;
        for (int a : cur) {
            if (!visited[a]) {
                count++;
            }
        }
        if (count == 0) {
            if (i == target) {
                dfs(i, target, t - 1, sum, visited);
            }
        } else {
            if (i == target) {
                return;
            }
            sum /= count;
            for (int x : cur) {
                if (!visited[x]) {
                    visited[x] = true;
                    dfs(x, target, t - 1, sum, visited);
                    //visited[x] = false;
                }
            }
        }
    }

    //dfs优化 ： 改为有向图
    public double frogPosition1(int n, int[][] edges, int t, int target) {
        for (int[] edge : edges) {
            int a = Math.min(edge[0], edge[1]);
            int b = Math.max(edge[0], edge[1]);
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);
        }
        dfs1(1, target, t, 1);
        return res;
    }

    private void dfs1(int i, int target, int t, double sum) {
        if (t <= 0) {
            if (i == target) {
                res += sum;
            }
            return;
        }
        List<Integer> cur = map.get(i);
        int count = cur == null ? 0 : cur.size();
        if (count == 0) {
            if (i == target) {
                dfs1(i, target, t - 1, sum);
            }
        } else {
            if (i == target) {
                return;
            }
            sum /= count;
            for (int x : cur) {
                dfs1(x, target, t - 1, sum);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_weekly_17904 lc = new Leetcode_weekly_17904();
        int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        System.out.println(lc.frogPosition(7, edges, 20, 2));
    }
}
