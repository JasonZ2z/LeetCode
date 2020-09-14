package com.xinzhe.contest.weekly.season05.weekly206;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/9/13
 * Title : 1584. 连接所有点的最小费用
 * Description : 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *              连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *              请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * link : https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_20603 {
    public static void main(String[] args) {
        Leetcode_weekly_20603 lc = new Leetcode_weekly_20603();
        int[][] arr = {{2,-3},{-17,-8},{13,8},{-17,-15}};
        System.out.println(lc.minCostConnectPoints(arr));
    }

    //prim
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[2]);
        int sum = 0;
        while (visited.size() < points.length) {
            int[] head = queue.remove();
            if (!visited.contains(head[0])) {
                visited.add(head[0]);
                sum += head[1];
                for (int i = 0; i < points.length; i++) {
                    if (!visited.contains(i)) {
                        queue.add(new int[] { i, getV(points[head[0]], points[i])});
                    }
                }
            }
        }
        return sum;
    }

    private int getV(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    //Kruskal
    public int minCostConnectPoints2(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>(n * (n-1) / 2);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                edges.add(new int[]{i, j, getV(points[i], points[j])});
            }
        }
        edges.sort(Comparator.comparingInt(e -> e[2]));
        UF uf = new UF(n);
        int cost = 0;
        for (int[] edge : edges) {
            if(uf.union(edge[0], edge[1])) {
                cost += edge[2];
                if (uf.count == 1) break;
            }
        }
        return cost;
    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return false;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
            return true;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
