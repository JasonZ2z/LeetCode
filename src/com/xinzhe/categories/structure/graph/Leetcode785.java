package com.xinzhe.categories.structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/7/16
 * Title : 785. 判断二分图
 * Description : 给定一个无向图graph，当这个图为二分图时返回true。如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *              graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * link : https://leetcode-cn.com/problems/is-graph-bipartite
 * Level : Medium
 */

public class Leetcode785 {
    public static void main(String[] args) {

    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if(visited[i] == 0) {
                visited[i] = 1;
            }
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j : graph[cur]) {
                    if(visited[j] == 0) {
                        visited[j] = visited[cur] * -1;
                        queue.offer(j);
                    } else if( visited[j] == visited[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
