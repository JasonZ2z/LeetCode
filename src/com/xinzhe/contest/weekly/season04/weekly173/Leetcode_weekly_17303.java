package com.xinzhe.contest.weekly.season04.weekly173;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/5/21
 * Title : 1334. 阈值距离内邻居最少的城市
 * Description : 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 *          返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 *          注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * link : https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
 * Level : Medium
 * Comment 173周赛03
 */

public class Leetcode_weekly_17303 {
    public static void main(String[] args) {
        //int[][] dp = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int[][] dp = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        Leetcode_weekly_17303 lc = new Leetcode_weekly_17303();
        System.out.println(lc.findTheCity(4, dp, 4));
    }

    int[][] dp;
    int n;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        dp = new int[n][n];
        this.n = n;
        for (int[] edge : edges) {
            dp[edge[0]][edge[1]] = edge[2];
            dp[edge[1]][edge[0]] = edge[2];
        }
        int min = n + 1;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int tmp = dfs(i, distanceThreshold);
            if (tmp < min) {
                min = tmp;
                res = i;
            }
        }

        return res;

    }

    private int dfs(int s, int distanceThreshold) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        boolean[] set = new boolean[n];
        Arrays.fill(dist, -1);

        dist[s] = 0;
        set[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] != 0) {
                    if (dist[j] == -1 || dist[j] > dist[i] + dp[i][j]) {
                        dist[j] = dist[i] + dp[i][j];
                        if (!set[j]) {
                            set[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
            set[i] = false;
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dist[i] == -1) continue;
            if (dist[i] <= distanceThreshold) res++;
        }
        return res;
    }

//    private void dfs(int pre, int i, int distanceThreshold) {
//        if(distanceThreshold == 0) return;
//        Set<Integer> set = res.get(i);
//        if(set.size() == n) return;
//        int[] arr = map.get(i);
//        for (int j = 0; j < arr.length; j++) {
//            if(j!= i && j != pre && arr[j] != 0 && !set.contains(j) && arr[j] <= distanceThreshold) {
//                if(pre != -1) res.get(pre).add(j);
//                else set.add(j);
//                dfs(i, j, distanceThreshold- arr[j]);
//            }
//        }
//    }

}
