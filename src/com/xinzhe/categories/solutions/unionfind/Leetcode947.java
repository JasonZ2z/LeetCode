package com.xinzhe.categories.solutions.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/01/15
 * Title : 947. 移除最多的同行或同列石头
 * Description : n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *              如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *              给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 * link : https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * Level : Medium
 */

public class Leetcode947 {
    public static void main(String[] args) {
        Leetcode947 lc = new Leetcode947();
        //int[][] arr = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int[][] arr = {{0,1},{1,0},{1,1}};
        System.out.println(lc.removeStones(arr));
    }

    Map<Integer, Integer> xline = new HashMap<>();
    Map<Integer, Integer> yline = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    int base = 10000;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        if(n == 1) return 0;
        Set<Integer> set = new HashSet<>();
        for(int[] s : stones) {
            int x = s[0], y = s[1], cur = s[0] * base + s[1];
            map.put(cur, cur);
            union(cur, x, y);
        }
        for(int[] s : stones) {
            set.add(find(s[0] * base + s[1]));
        }
        return n - set.size();
    }

    private void union(int s, int i, int j) {
        if(xline.containsKey(i) && yline.containsKey(j)) {
            int x = xline.get(i);
            int y = yline.get(j);
            merge(s, x);
            merge(s, y);
            merge(x, y);
        } else if(xline.containsKey(i)) {
            int x = xline.get(i);
            merge(s, x);
            yline.put(j, s);
        } else if(yline.containsKey(j)) {
            int y = yline.get(j);
            merge(s, y);
            xline.put(i, s);
        } else {
            xline.put(i, s);
            yline.put(j, s);
        }
    }

    private void merge(int s, int x) {
        int fs = find(s);
        int fx = find(x);
        if(fs == fx) return;
        if(fs > fx) {
            map.put(fx, fs);
        } else {
            map.put(fs, fx);
        }
    }

    private int find(int s) {
        while (s != map.get(s)) {
            s = map.get(s);
        }
        return s;
    }

}
