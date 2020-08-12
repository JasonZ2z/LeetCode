package com.xinzhe.categories.solutions.bfs.medium;

import java.util.*;

/**
 * @author Xin
 * @date 2020/6/29
 * Title : 787. K 站中转内最便宜的航班
 * Description : 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *              现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * link : https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * Level : Medium
 */

public class Leetcode787 {
    public static void main(String[] args) {
        int[][] arr ={{0,1,1},{0,2,5},{1,2,1},{2,3,1}, {3,4,1}};
        Leetcode787 lc = new Leetcode787();
        System.out.println(lc.findCheapestPrice(5,arr,0,4,2));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> dist = new HashMap<>(n);
        for (int[] f : flights) {
            int s = f[0], d = f[1], p = f[2];
            dist.computeIfAbsent(s, a -> new ArrayList<>());
            dist.get(s).add(new int[]{d,p});

        }
        LinkedList<int[]> queue = new LinkedList<>();
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty() && k-- >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] j : dist.getOrDefault(cur[0], new ArrayList<>())) {
                    if(cost[j[0]] > cur[1] + j[1]) {
                        cost[j[0]] = cur[1] + j[1];
                        queue.offer(new int[]{j[0], cur[1] + j[1]});
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
