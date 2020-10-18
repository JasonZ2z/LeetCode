package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21104 {
    public static void main(String[] args) {
        Leetcode_weekly_21104 lc = new Leetcode_weekly_21104();
        int[] arr = {3,5};
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        //Map<Integer, Set<Integer>> map = new HashMap<>();
        UF uf = new UF(n + 1);
        if(threshold < 1) {
            for (int i = 0; i < queries.length; ++i) {
                res.add(true);
            }
            return res;
        }
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            if(a == b) {
                res.add(true);
            }
            if(uf.connected(a-1, b-1)) {
                res.add(true);
                continue;
            }
            int x = gcd(a, b);
            if(x > threshold) {
                res.add(true);
                uf.union(a-1, b-1);
            }else {
                res.add(false);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if(!res.get(i)) {
                if(uf.connected(queries[i][0]-1, queries[i][1]-1)) {
                    res.set(i, true);
                }
            }
        }
        return res;
    }
    private int gcd(int a, int b){
        return a==0? b : gcd(b%a , a);
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
