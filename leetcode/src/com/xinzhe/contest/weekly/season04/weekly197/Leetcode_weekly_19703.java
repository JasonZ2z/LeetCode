package com.xinzhe.contest.weekly.season04.weekly197;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_19703 {
    public static void main(String[] args) {
        Leetcode_weekly_19703 lc = new Leetcode_weekly_19703();
        int[][] arr = {{0,1},{1,2},{0,2}};
        double[] suc = {0.5,0.5,0.2};
        System.out.println(lc.maxProbability(3, arr, suc, 0, 2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0],b = edges[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>());
            map.get(a).add(new Node(a, b, succProb[i]));

            map.computeIfAbsent(b, k -> new ArrayList<>());
            map.get(b).add(new Node(b, a, succProb[i]));

        }
        double[] dp = new double[n];
        dp[start] = 1.0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Node> tmp = map.getOrDefault(cur, new ArrayList<>());
            for (Node node : tmp) {
                if(dp[cur] * node.value > dp[node.to]) {
                    queue.add(node.to);
                    dp[node.to] = dp[cur] * node.value;
                }
            }
        }
        return dp[end];
    }

    class Node{
        int from;
        int to;
        double value;

        public Node(int from, int to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}
