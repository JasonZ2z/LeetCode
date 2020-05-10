package com.xinzhe.order.day13;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18803 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return Math.max(0, minTime(0, graph, hasApple, new boolean[n]) - 2);
    }

    private int minTime(int n, ArrayList<Integer>[] graph, List<Boolean> hasApple, boolean[] visited) {
        if (!visited[n]) {
            visited[n] = true;
            int sum = 0;
            for (int i : graph[n]) {
                sum += minTime(i, graph, hasApple, visited);
            }
            if (sum > 0) {
                return sum + 2;
            } else {
                return hasApple.get(n) ? 2 : 0;
            }
        }
        return 0;
    }
}
