package com.xinzhe.contest.weekly.season05.weekly223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/01/10
 * Title : 1722. 执行交换操作后的最小汉明距离
 * Description : 给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，
 *              其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 *              相同长度的两个数组source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 *              在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 * link : https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations
 * Level : Medium
 */
public class Leetcode_weekly_22303 {
    public static void main(String[] args) {
        Leetcode_weekly_22303 lc = new Leetcode_weekly_22303();
        int[] arr = {5,1,2,4,3};
        int[] arr2 = {1,5,4,2,3};
        int[][] arr3 = {{0,4}, {4,2},{1,3},{1,4}};
        System.out.println(lc.minimumHammingDistance(arr, arr2, arr3));
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UF uf = new UF(n);
        for(int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        int res = n;
        boolean[] used = new boolean[n];
        for(int i=0; i<n; i++) {
            if(used[i]) continue;
            List<Integer> set = new ArrayList<>(uf.coll.get(uf.find(i)));
            if(set.size() > 0) {
                int[] s = new int[set.size()];
                int[] t = new int[set.size()];
                for(int j=0; j<set.size(); j++) {
                    used[set.get(j)] = true;
                    s[j] = source[set.get(j)];
                    t[j] = target[set.get(j)];
                }
                Arrays.sort(s);
                Arrays.sort(t);
                int p = 0, q = 0, cnt = 0;
                while(p < s.length && q < t.length) {
                    int o = Integer.compare(s[p], t[q]);
                    if(o == 0) {
                        p++;
                        q++;
                        cnt++;
                    } else if(o > 0) {
                        q++;
                    } else {
                        p++;
                    }
                }
                res -= cnt;
            }
        }
        return res;
    }

    class UF{
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> coll = new HashMap<>();
        public UF(int n){
            for(int i=0; i<n; i++) {
                map.put(i, i);
                coll.computeIfAbsent(i, a -> new HashSet<>()).add(i);
            }
        }

        private int find(int x) {
            while(map.get(x) != x) {
                x = map.get(map.get(x));
            }
            return x;
        }

        private void union(int p, int q) {
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;
            if(fp > fq) {
                map.put(fp, fq);
                coll.get(fq).addAll(coll.get(fp));
            } else {
                map.put(fq, fp);
                coll.get(fp).addAll(coll.get(fq));
            }
        }
    }
}
