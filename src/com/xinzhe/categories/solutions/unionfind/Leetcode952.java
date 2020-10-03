package com.xinzhe.categories.solutions.unionfind;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/31
 * Title : 952. 按公因数计算最大组件大小
 * Description : 给定一个由不同正整数的组成的非空数组 A，考虑下面的图：有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记；
 *              只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。 返回图中最大连通组件的大小。
 * link : https://leetcode-cn.com/problems/largest-component-size-by-common-factor
 * Level : Hard
 */

public class Leetcode952 {
    public int largestComponentSize(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().orElse(0);
        UF uf = new UF(max + 1);
        for(int a : arr) {
            for(int i = 2; i<=Math.sqrt(a); i++) {
                if(a % i == 0) {
                    uf.union(a, i);
                    uf.union(a, a/i);
                }
            }
        }

        int[] cnt = new int[max + 1];
        int res = 1;
        for(int a :arr) {
            int root = uf.find(a);
            cnt[root]++;
            res = Math.max(res, cnt[root]);
        }
        return res;
    }

    class UF{
        int[] parent;
        int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;

            if(size[fp] > size[fq]) {
                parent[fq] = fp;
                size[fp] +=size[fq];
            } else {
                parent[fp] = fq;
                size[fq] +=size[fp];
            }

        }
    }
}
