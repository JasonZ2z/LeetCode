package com.xinzhe.contest.weekly.season04.weekly155;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author Xin
 * @create 2020/7/27
 * Title : 1202. 交换字符串中的元素
 * Description : 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *              你可以 任意多次交换 在 pairs 中任意一对索引处的字符。返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * link : https://leetcode-cn.com/problems/smallest-string-with-swaps
 * Level : Medium
 * tag : 并查集
 */

//todo need to review
public class Leetcode_weekly_15503 {

    public static void main(String[] args) {
        Leetcode_weekly_15503 lc = new Leetcode_weekly_15503();
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UF uf = new UF(n);
        for(List<Integer> pair : pairs) {
            int p = pair.get(0), q = pair.get(1);
            uf.union(p,q);
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(n);
        for(int i =0; i<n; i++) {
            map.computeIfAbsent(uf.find(i), o -> new PriorityQueue<>()).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++) {
            sb.append(map.get(uf.find(i)).poll());
        }
        return sb.toString();

    }

    class UF{
        int[] father;
        public UF(int n) {
            father = new int[n];
            for(int i =0; i<n; i++) {
                father[i] = i;
            }
        }

        public int find(int p) {
            while(father[p] != p) {
                p = father[father[p]];
            }
            return p;
        }

        public void union(int p, int q) {
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;
            if(fp <  fq) father[fq] = fp;
            else father[fp] = fq;
        }
    }

}
