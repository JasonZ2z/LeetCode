package com.xinzhe.contest.weekly.season04.weekly191;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/5/31
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 191周赛03
 */
public class Leetcode_weekly_19103 {
    int count = 0;
    Set<Integer>[] undigraph; //无向图
    boolean[] visited;
    Set<Integer>[] digraph; //有向图

    public int minReorder(int n, int[][] connections) {
        this.undigraph = new Set[n];
        this.digraph = new Set[n];
        this.visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            undigraph[i] = new HashSet<>();
            digraph[i] = new HashSet<>();
        }
        for (int[] connection : connections) {
            digraph[connection[0]].add(connection[1]);
            undigraph[connection[0]].add(connection[1]);
            undigraph[connection[1]].add(connection[0]);
        }
        for (int i = 0; i < n; ++i) {
            helper(i);
        }
        return count;
    }

    private void helper(int i) {
        Set<Integer> set = undigraph[i];
        if (set.size() == 0) return;
        visited[i] = true;
        for (Integer j : set) {
            if (visited[j]) continue;
            if (digraph[j].size() == 0 || !digraph[j].contains(i)) {
                count++;
            }
            visited[j] = true;
        }
    }

}
