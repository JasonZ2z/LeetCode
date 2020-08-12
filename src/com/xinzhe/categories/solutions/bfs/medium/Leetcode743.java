package com.xinzhe.categories.solutions.bfs.medium;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/7/1
 * Title : 743. 网络延迟时间
 * Description : 有 N 个网络节点，标记为 1 到 N。
 *          给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 *          现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * link : https://leetcode-cn.com/problems/network-delay-time
 * Level : Medium
 */

public class Leetcode743 {
    public static void main(String[] args) {
        int[][] arr ={{2,1,1},{2,3,1}, {3,4,1}};
        Leetcode743 lc = new Leetcode743();
        System.out.println(lc.networkDelayTime(arr,4,2));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] t : times) {
            int u = t[0]-1, v = t[1]-1, w = t[2];
            map.computeIfAbsent(u, a -> new ArrayList<>());
            map.get(u).add(new int[]{v, w});
        }
        k--;
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k, 0});
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
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if(visited[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, visited[i]);
        }
        return max;
    }
}
