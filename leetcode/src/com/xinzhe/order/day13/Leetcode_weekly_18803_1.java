package com.xinzhe.order.day13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18803_1 {
    public int minTime2(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for(int[] i : edges) {
            graph.putIfAbsent(i[0], new HashSet());
            graph.get(i[0]).add(i[1]);
        }
        int[] num = new int[n];
        int[] step = new  int[n];
        for(int i = n - 1; i >= 0; i--) {
            if(hasApple.get(i)) num[i] = 1;
            if(graph.containsKey(i)) {
                for(int j : graph.get(i)) {
                    if(num[j] != 0) {
                        num[i] += num[j];
                        step[i] += step[j] + 2;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(step));
        return step[0];
    }
}
