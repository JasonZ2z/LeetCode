package com.xinzhe.contest.weekly.season04.weekly197;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_19703 {
    public static void main(String[] args) {
        Leetcode_weekly_19703 lc = new Leetcode_weekly_19703();
        int[][] arr = {{2,3},{1,2},{3,4},{1,3},{1,4},{0,1},{2,4},{0,4},{0,2}};
        double[] suc = {0.06,0.26,0.49,0.25,0.2,0.64,0.23,0.21,0.77};
        System.out.println(lc.maxProbability(5, arr, suc, 0, 3));
    }


    int end;
    double max = 0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        this.end = end;
        Map<Integer, List<Node>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], a -> new ArrayList<>());
            map.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));

            map.computeIfAbsent(edges[i][1], a -> new ArrayList<>());
            map.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));

        }
        boolean[] visited = new boolean[n];
        dfs(map, start, 1, visited);
        return max;
    }

    class Node{
        int index;
        double value;

        public Node(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    private void dfs(Map<Integer, List<Node>> map, int start, double value, boolean[] visited) {
        if(start == end) {
            max = Math.max(max, value);
            return;
        }
        if(value < max) return;
        List<Node> nodes = map.getOrDefault(start, new ArrayList<>());
        visited[start] = true;
        for (Node node : nodes) {
           if(!visited[node.index] ){
               dfs(map, node.index, value * node.value, visited.clone());
            }
        }
    }
}
