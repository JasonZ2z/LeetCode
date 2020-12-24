package com.xinzhe.contest.weekly.season05.weekly220;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Xin
 * @date 2020/12/20
 * Title : 1697. 检查边长度限制的路径是否存在
 * Description : 给你一个 n个点组成的无向图边集edgeList，其中edgeList[i] = [ui, vi, disi]表示点ui 和点vi之间有一条长度为disi的边。请注意，两个点之间可能有 超过一条边。
 *              给你一个查询数组queries，其中queries[j] = [pj, qj, limitj]，你的任务是对于每个查询queries[j]，判断是否存在从pj到qj的路径，且这条路径上的每一条边都 严格小于limitj。
 *              请你返回一个 布尔数组answer，其中answer.length == queries.length，当queries[j]的查询结果为true时，answer 第j个值为true，否则为false。
 * link : https://leetcode-cn.com/problems/checking-existence-of-edge-length-limited-paths
 * Level : Hard
 */
public class Leetcode_weekly_22004 {
    public static void main(String[] args) {
        Leetcode_weekly_22004 lc = new Leetcode_weekly_22004();
        int[] arr = {3,5};
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        int[][] arr = new int[m][4];
        for (int i = 0; i < m; i++) {
            arr[i][0] = i;
            arr[i][1] = queries[i][0];
            arr[i][2] = queries[i][1];
            arr[i][3] = queries[i][2];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[3]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        boolean[] res = new boolean[m];
        UF uf = new UF(n);
        for (int i = 0,j = 0; i < m; ++i) {
            int[] cur = arr[i];
            while (j < edgeList.length && edgeList[j][2] < cur[3]) {
                uf.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            res[cur[0]] = uf.connected(cur[1], cur[2]);
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
