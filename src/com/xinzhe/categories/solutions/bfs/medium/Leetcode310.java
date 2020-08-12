package com.xinzhe.categories.solutions.bfs.medium;

import java.util.*;

/**
 * @author Xin
 * @date 2020/6/27
 * Title : 310. 最小高度树
 * Description : 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 *              给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * link : https://leetcode-cn.com/problems/minimum-height-trees
 * Level : Medium
 */
public class Leetcode310 {
    //todo need to review
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Set<Integer>[] graph = new HashSet[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if(degree[i] == 1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int next = queue.poll();
                res.add(next);
                for (int k : graph[next]) {
                    degree[k]--;
                    if (degree[k] == 1) {
                        queue.offer(k);
                    }
                }
            }
        }
        return res;
    }
}
