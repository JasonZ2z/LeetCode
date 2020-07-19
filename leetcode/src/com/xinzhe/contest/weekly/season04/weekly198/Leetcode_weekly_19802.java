package com.xinzhe.contest.weekly.season04.weekly198;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/7/19
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_19802 {
    public static void main(String[] args) {
        Leetcode_weekly_19802 lc = new Leetcode_weekly_19802();
        int[][] arr = {{0,2},{0,3},{1,2}};
        String s = "aeed";
        System.out.println(Arrays.toString(lc.countSubTrees(4, arr, s)));
    }

    char[] dist;
    int[] res;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.dist = labels.toCharArray();
        res = new int[n];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.computeIfAbsent(a, x -> new HashSet<>());
            map.computeIfAbsent(b, x -> new HashSet<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        helper(new Node(0, dist[0]), -1);
        return res;
    }

    private void helper(Node node, int father) {
        Set<Integer> set = map.getOrDefault(node.index, new HashSet<>());
        for (Integer j : set) {
            if(j == father) continue;
            Node cur = new Node(j, dist[j]);
            helper(cur, node.index);
            for (int k = 0; k < 26; ++k) {
                node.arr[k] += cur.arr[k];
            }
        }
        res[node.index] = node.arr[node.label - 'a'];
    }

    class Node {
        int index;
        char label;
        int[] arr;
        public Node(int index, char label) {
            this.index = index;
            this.label = label;
            this.arr = new int[26];
            arr[label - 'a']++;
        }
    }
}
