package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/18
 * Title : 1627. 带阈值的图连通性
 * Description : 有 n 座城市，编号从 1 到 n 。编号为 x 和 y 的两座城市直接连通的前提是： x 和 y 的公因数中，至少有一个 严格大于 某个阈值 threshold 。更正式地说，如果存在整数 z ，且满足以下所有条件，则编号 x 和 y 的城市之间有一条道路：
 *               x % z == 0 && y % z == 0 && z > threshold
 *              给你两个整数 n 和 threshold ，以及一个待查询数组，请你判断每个查询 queries[i] = [ai, bi] 指向的城市 ai 和 bi 是否连通（即，它们之间是否存在一条路径）。
 *              返回数组 answer ，其中answer.length == queries.length 。如果第 i 个查询中指向的城市 ai 和 bi 连通，则 answer[i] 为 true ；如果不连通，则 answer[i] 为 false 。
 * link : https://leetcode-cn.com/problems/graph-connectivity-with-threshold
 * Level : Hard
 */
//todo need to review
//线性筛法预处理+并查集
public class Leetcode_weekly_21104 {
    public static void main(String[] args) {
        Leetcode_weekly_21104 lc = new Leetcode_weekly_21104();
        int[] arr = {3,5};
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        UF uf = new UF(n + 1);
        if(threshold < 1) {
            for (int i = 0; i < queries.length; ++i) {
                res.add(true);
            }
            return res;
        }
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = 2; j * threshold <= n ; ++j) {
                uf.union(i, j * i);
            }
        }
        for (int[] query : queries) {
            if(uf.connected(query[0], query[1])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
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

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
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
