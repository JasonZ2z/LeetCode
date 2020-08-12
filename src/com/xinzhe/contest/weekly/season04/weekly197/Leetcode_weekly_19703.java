package com.xinzhe.contest.weekly.season04.weekly197;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title : 1514. 概率最大的路径
 * Description : 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 *              指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 *              如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 * link : https://leetcode-cn.com/problems/path-with-maximum-probability
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
