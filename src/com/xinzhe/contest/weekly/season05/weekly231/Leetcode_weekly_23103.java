package com.xinzhe.contest.weekly.season05.weekly231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Xin
 * @date 2021/03/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23103 {
    public static void main(String[] args) {
        Leetcode_weekly_23103 lc = new Leetcode_weekly_23103();
        int[][] edge = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        System.out.println(lc.countRestrictedPaths(5, edge));
    }

    static final int MOD = (int)1e9 + 7;
    Map<Integer, List<int[]>> map = new HashMap<>();

    public int countRestrictedPaths(int n, int[][] edges) {
        for (int[] edge : edges) {
            int u =  edge[0] - 1, v = edge[1]-1, w = edge[2];
            map.computeIfAbsent(u, a -> new ArrayList<>());
            map.computeIfAbsent(v, a -> new ArrayList<>());
            map.get(u).add(new int[]{v, w});
            map.get(v).add(new int[]{u, w});
        }
        int[] visited = new int[n];
        int[] count = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[n-1] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n-1, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] tmp : map.getOrDefault(cur[0], new ArrayList<>())) {
                    int money = cur[1] + tmp[1];
                    if(visited[tmp[0]] > money) {
                        visited[tmp[0]] = money;
                        queue.offer(new int[]{tmp[0], money});
                    }
                }
            }
        }

        return count[0];
    }
}
