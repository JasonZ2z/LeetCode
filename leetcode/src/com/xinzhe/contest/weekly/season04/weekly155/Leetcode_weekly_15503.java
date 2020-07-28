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
}
