package com.xinzhe.contest.weekly.season03.weekly146;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 1129. 颜色交替的最短路径
 * Description : 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 *              red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *              返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 * link : https://leetcode-cn.com/problems/shortest-path-with-alternating-colors
 * Level : Medium
 */

//todo need to review
public class Leetcode_weekly_14602 {
    ArrayList<Integer>[] red;
    ArrayList<Integer>[] blue;
    int[] res;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        this.red = new ArrayList[n];
        this.blue = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        for (int[] edge : red_edges) red[edge[0]].add(edge[1]);
        for (int[] edge : blue_edges) blue[edge[0]].add(edge[1]);
        this.res = new int[n];
        Arrays.fill(res,-1);
        bfs(n, 1);
        bfs(n, 2);
        return res;
    }

    private void bfs(int n,  int color) {
        int[] colors = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                if(colors[cur] > 2) continue;
                if(color == 1) {
                    for (int j : red[cur]) {
                        if((colors[j] == 0 || colors[j] == color) && !set.contains(j)) {
                            queue.offer(j);
                            set.add(j);
                        }
                    }
                } else {
                    for (int j : blue[cur]) {
                        if((colors[j] == 0 || colors[j] == color) && !set.contains(j)) {
                            queue.offer(j);
                            set.add(j);
                        }
                    }
                }
                if(res[cur] == -1) res[cur] = count;
                else res[cur] = Math.min(res[cur], count);
                colors[cur] += color;
            }
            set.clear();
            color = 3 -color;
            count++;
        }
    }
}
