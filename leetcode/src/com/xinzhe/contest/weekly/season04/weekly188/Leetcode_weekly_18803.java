package com.xinzhe.contest.weekly.season04.weekly188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title : 1443. 收集树上所有苹果的最少时间
 * Description : 给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。
 *              你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 *              无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。
 *              除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 * link : https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 * Level : Medium
 * tag : dfs, graph
 */
//todo need to review
public class Leetcode_weekly_18803 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        dfs(hasApple, 0);
        return count(hasApple, 0);
    }

    private int count(List<Boolean> hasApple, int i) {
        int res = 0;
        for (int next : map.get(i)) {
            if(hasApple.get(next)) {
                res += 2 + count(hasApple, next);
            }
        }
        return res;
    }

    private boolean dfs(List<Boolean> hasApple, int i) {
        boolean ans = hasApple.get(i);
        for (int next : map.get(i)) {
            if(dfs(hasApple, next)) {
                ans = true;
            }
        }
        hasApple.set(i, ans);
        return ans;
    }

    //从下至上遍历
    public int minTime2(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] i : edges) {
            graph.putIfAbsent(i[0], new HashSet<>());
            graph.get(i[0]).add(i[1]);
        }
        int[] num = new int[n];
        int[] step = new  int[n];
        for(int i = n - 1; i >= 0; i--) {
            if(hasApple.get(i)) num[i] = 1;
            if(graph.containsKey(i)) {
                for(int j : graph.get(i)) {
                    if(num[j] != 0) {
                        num[i] += num[j];
                        step[i] += step[j] + 2;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(step));
        return step[0];
    }
}
