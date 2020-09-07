package com.xinzhe.contest.weekly.season05.weekly205;

/**
 * @author Xin
 * @date 2020/9/6
 * Title : 1579. 保证图可完全遍历
 * Description : Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *          类型 1：只能由 Alice 遍历。类型 2：只能由 Bob 遍历。类型 3：Alice 和 Bob 都可以遍历。
 *          给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *          返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1
 * link : https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
 * Level : Hard
 */
public class Leetcode_weekly_20504 {
    public static void main(String[] args) {
        Leetcode_weekly_20504 lc = new Leetcode_weekly_20504();
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF uf1 = new UF(n), uf2 = new UF(n), uf3 = new UF(n);
        int cnt = 0, c1 = 0, c2 = 0;
        for (int[] edge : edges) {
            int type = edge[0], from = edge[1]-1, to = edge[2]-1;
            if(type == 3) cnt += uf3.union(from, to) ? 1 : 0;
            if(type == 1) c1++;
            if(type == 2) c2++;
            if(type == 1 || type == 3) uf1.union(from, to);
            if(type == 2 || type == 3) uf2.union(from, to);
        }
        if(uf3.count == 1) return c1 + c2;
        if(uf1.count == 1 && uf2.count == 1) {
            return cnt + (c1 - uf3.count  + 1) + (c2 - uf3.count + 1);
        }
        return -1;
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
                return true;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
            return false;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
