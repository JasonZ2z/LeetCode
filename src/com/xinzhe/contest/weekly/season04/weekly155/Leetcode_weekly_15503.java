package com.xinzhe.contest.weekly.season04.weekly155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/7/27
 * Title : 1202. 交换字符串中的元素
 * Description : 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *              你可以 任意多次交换 在 pairs 中任意一对索引处的字符。返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * link : https://leetcode-cn.com/problems/smallest-string-with-swaps
 * Level : Medium
 * tag : 并查集
 */

//todo need to review
public class Leetcode_weekly_15503 {

    public static void main(String[] args) {
        Leetcode_weekly_15503 lc = new Leetcode_weekly_15503();
        String s = "otilzqqoj";
        int[][] pairs = {{2,3},{7,3},{3,8},{1,7},{1,0},{0,4},{0,6},{3,4},{2,5}};
        //"otilzqqoj"
        //[[2,3],[7,3],[3,8],[1,7],[1,0],[0,4],[0,6],[3,4],[2,5]]
        System.out.println(lc.smallestStringWithSwaps2(s, pairs));
    }

    private int[] dp;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        this.dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i]=i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            map.computeIfAbsent(find(i), v -> new PriorityQueue<>()).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();

    }

    public int find(int x){
        while(dp[x] != x) {
            x = dp[dp[x]];
        }
        return x;
    }

    public void union(int p, int q) {
        int fp = find(p);
        int fq = find(q);
        if(fp == fq) return;
        if(fp <  fq) dp[fq] = fp;
        else dp[fp] = fq;
    }


    public String smallestStringWithSwaps2(String s, int[][] pairs) {
        int n = s.length();
        char[] arr = s.toCharArray();
        UF uf = new UF(n);
        for(int[] pair : pairs) {
            uf.union(pair[0], pair[1]);
        }
        char[] res = new char[n];
        boolean[] used = new boolean[n];
        for(int i=0; i<n; i++) {
            if(used[i]) continue;
            List<Integer> set = new ArrayList<>(uf.coll.get(uf.find(i)));
            if(set.size() == 0) continue;
            else if(set.size() == 1) res[set.get(0)] = arr[set.get(0)];
            else {
                char[] val = new char[set.size()];
                for(int j=0; j<set.size(); j++) {
                    used[set.get(j)] = true;
                    val[j] = arr[set.get(j)];
                }
                Collections.sort(set);
                Arrays.sort(val);
                for(int k =0; k<set.size(); k++) {
                    res[set.get(k)] = val[k];
                }
            }
        }
        return new String(res);

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
