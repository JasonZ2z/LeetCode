package com.xinzhe.contest.weekly.season04.weekly198;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/7/19
 * Title : 1519. 子树中标签相同的节点数
 * Description : 给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges .
 *              树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）边数组 edges 以 edges[i] = [ai, bi] 的形式给出，
 *              该格式表示节点 ai 和 bi 之间存在一条边。返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
 * link : https://leetcode-cn.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label
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
