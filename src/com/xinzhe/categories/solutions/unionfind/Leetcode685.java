package com.xinzhe.categories.solutions.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/17
 * Title : 685. 冗余连接 II
 * Description : 在本问题中, 树指的是一个连通且无环的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 *          输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *          结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *          返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * link : https://leetcode-cn.com/problems/redundant-connection-ii/
 * Level : Hard
 */

public class Leetcode685 {
    public static void main(String[] args) {
        Leetcode685 lc = new Leetcode685();
        int[][] e = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        System.out.println(Arrays.toString(lc.findRedundantDirectedConnection(e)));
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for(int[] e : edges) {
            out[e[0]]++;
            in[e[1]]++;
        }
        int target = 0, root = 0;
        for(int i=1; i<=n; i++) {
            if(in[i] == 0) root = i;
            if(in[i] > 1) target = i;
        }
        if(root == 0) {
           for(int i = n-1; i >= 0; --i) {
               if(in[edges[i][1]] == 1 && out[edges[i][1]] != 0) {
                   return edges[i];
               }
           }
        }
        if(target != 0) {
            List<int[]> list = new ArrayList<>();
            UF uf1 = new UF(n+1);
            for (int[] edge : edges) {
                if(edge[1] != target) {
                    uf1.union(edge[0], edge[1]);
                } else {
                    list.add(edge);
                }
            }
            int[] e1 = list.get(0);
            if(uf1.union(e1[0], e1[1])) return e1;
            return list.get(1);
        }
        return new int[0];
    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private final int[] parent;
        // 记录树的“重量”
        private final int[] size;

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
