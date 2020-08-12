package com.xinzhe.contest.weekly.season04.weekly171;

/**
 * @Author Xin
 * @create 2020/5/25
 * Title : 1319. 连通网络的操作次数
 * Description : 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *          网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *          给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 * link : https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * Level : Medium
 * Comment 171周赛03
 */

public class Leetcode_weekly_17103 {


    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (n - m > 1) return -1;

        UF uf = new UF(n);
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (uf.parent[i] == i) count++;
        }
        return count - 1;
    }

    static class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q) {
            int fp = find(p);
            int fq = find(q);
            if (fp == fq) return;
            if (fp < fq) {
                parent[fq] = fp;
            } else {
                parent[fp] = fq;
            }
        }
    }
}
