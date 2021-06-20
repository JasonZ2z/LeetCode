package com.xinzhe.contest.biweeekly.s1.biweekly44;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/01/23
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4402 {
    public static void main(String[] args) {
        Leetcode_biweekly_4402 lc = new Leetcode_biweekly_4402();

        int[][] arr = {{4,7,2,14,6},{15,13,6,3,2,7,10,8,12,4,9},{16},{10},{10,3},{4,12,8,1,16,5,15,17,13},{4,13,15,8,17,3,6,14,5,10},{11,4,13,8,3,14,5,7,15,6,9,17,2,16,12},{4,14,6},{16,17,9,3,11,14,10,12,1,8,13,4,5,6},{14},{7,14},{17,15,10,3,2,12,16,14,1,7,9,6,4}};
        int[][] arr2 ={{4,11},{3,5},{7,10},{10,12},{5,7},{4,5},{3,8},{1,5},{1,6},{7,8},{4,12},{2,4},{8,9},{3,10},{4,7},{5,12},{4,9},{1,4},{2,8},{1,2},{3,4},{5,10},{2,7},{1,7},{1,8},{8,10},{1,9},{1,10},{6,7},{3,7},{8,12},{7,9},{9,11},{2,5},{2,3}};
//        int[][] arr = {{1},{2},{1,2}};
//        int[][] arr2 = {{1,2},{1,3},{2,3}};
        System.out.println(lc.minimumTeachings(17, arr, arr2));
        System.out.println(lc.minimumTeachings2(17, arr, arr2));

    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] lang = new HashSet[m+1];
        for (int i = 0; i < m; i++) {
            lang[i+1] = new HashSet<>();
            for (int language : languages[i]) {
                lang[i+1].add(language);
            }
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] friendship : friendships) {
            if(!helper(lang, friendship[0], friendship[1])) continue;
            map.computeIfAbsent(friendship[0], a -> new HashSet<>()).add(friendship[1]);
            map.computeIfAbsent(friendship[1], a -> new HashSet<>()).add(friendship[0]);
        }

        int res = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Set<Integer> value = entry.getValue();

            Map<Integer, Integer> tmp = new HashMap<>();
            for (Integer i : lang[key]) {
                tmp.put(i, tmp.getOrDefault(i, 0) + 1);
            }
            for (Integer j : value) {
                for (Integer i : lang[j]) {
                    tmp.put(i, tmp.getOrDefault(i, 0) + 1);
                }
            }
            int mc = 0, mv = 0;
            for (Map.Entry<Integer, Integer> integerEntry : tmp.entrySet()) {
                if(mc == 0 && mv == 0) {
                    mc = integerEntry.getValue();
                    mv = integerEntry.getKey();
                } else if(mc < integerEntry.getValue()) {
                    mv = integerEntry.getKey();
                    mc = integerEntry.getValue();
                }
            }
            if(!lang[key].contains(mv)) {
                res++;
            }
            for (Integer j : value) {
                if(!lang[j].contains(mv)) {
                    res++;
                    map.get(j).removeIf(x -> x.equals(key));
                }
            }
        }
        return res;
    }

    private boolean helper(Set<Integer>[] lang, int i, int j) {
        Set<Integer> s1 = lang[i];
        Set<Integer> s2 = lang[j];
        for (Integer k : s1) {
            if(s2.contains(k)) return false;
        }
        return true;
    }

    public int minimumTeachings2(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] lang = new HashSet[m+1];
        for (int i = 0; i < m; i++) {
            lang[i+1] = new HashSet<>();
            for (int language : languages[i]) {
                lang[i+1].add(language);
            }
        }
        int res = 0;
        UF uf = new UF(m+1);
        boolean[] used = new boolean[friendships.length];
        for (int i = 0; i < friendships.length; i++) {
            int[] friendship = friendships[i];
            if(!helper(lang, friendship[0], friendship[1])) {
                used[i] = true;
            } else {
                uf.union(friendship[0], friendship[1]);
            }
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            if(uf.find(i) == i) continue;
            map.computeIfAbsent(uf.find(i), a -> new HashSet<>()).add(i);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Set<Integer> value = entry.getValue();

            Map<Integer, Integer> tmp = new HashMap<>();
            for (Integer i : lang[key]) {
                tmp.put(i, tmp.getOrDefault(i, 0) + 1);
            }
            for (Integer j : value) {
                for (Integer i : lang[j]) {
                    tmp.put(i, tmp.getOrDefault(i, 0) + 1);
                }
            }
            int mc = 0, mv = 0;
            for (Map.Entry<Integer, Integer> integerEntry : tmp.entrySet()) {
                if(mc == 0 && mv == 0) {
                    mc = integerEntry.getValue();
                    mv = integerEntry.getKey();
                } else if(mc < integerEntry.getValue()) {
                    mv = integerEntry.getKey();
                    mc = integerEntry.getValue();
                }
            }
            if(!lang[key].contains(mv)) {
                res++;
            }
            for (Integer j : value) {
                if(!lang[j].contains(mv)) {
                    res++;
                }
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