package com.xinzhe.contest.weekly.season05.weekly228;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/02/07
 * Title : 1761. 一个图中连通三元组的最小度数
 * Description :  给你一个无向图，整数 n表示图中节点的数目，edges数组表示图中的边，其中edges[i] = [ui, vi]，表示ui 和vi之间有一条无向边。
 *              一个 连通三元组指的是 三个节点组成的集合且这三个点之间 两两有边。
 *              连通三元组的度数是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 *              请你返回所有连通三元组中度数的 最小值，如果图中没有连通三元组，那么返回 -1。
 * link : https://leetcode-cn.com/problems/minimum-degree-of-a-connected-trio-in-a-graph
 * Level : Hard
 */
public class Leetcode_weekly_22804 {
    public static void main(String[] args) {
        Leetcode_weekly_22804 lc = new Leetcode_weekly_22804();
    }
    public int minTrioDegree(int n, int[][] edges) {
        Set<Integer>[] graph = new HashSet[n + 1];
        int[] degree = new int[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int min = Integer.MAX_VALUE;
        for (int a = 1; a < graph.length; a++) {
            for (int b : graph[a]) {
                for (int c = b+1; c < n; ++c) {
                    if(graph[a].contains(c) && graph[b].contains(c)) {
                        min = Math.min(min, degree[a] + degree[b] + degree[c] - 6);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
