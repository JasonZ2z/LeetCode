package com.xinzhe.sword.chapter04;

import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 04.01. 节点间通路
 * Description : 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径
 * link : https://leetcode-cn.com/problems/route-between-nodes-lcci/
 * Level : Medium
 */
public class Interview_0401 {
    HashSet<Integer>[] set;
    boolean[] used;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
         this.used= new boolean[n];
        this.set = new HashSet[n];
        for (int i = 0; i < n; ++i) set[i] = new HashSet<>();
        for (int[] g : graph) set[g[0]].add(g[1]);
        return dfs(start, target);
    }

    private boolean dfs(int start, int target) {
        if(start == target) return true;
        used[start] = true;
        for (Integer i : set[start]) {
            if(!used[i]) {
                if(dfs(i , target)) return true;
            }
        }
        return false;
    }
}
