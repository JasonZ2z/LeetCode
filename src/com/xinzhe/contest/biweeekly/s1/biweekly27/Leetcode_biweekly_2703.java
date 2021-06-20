package com.xinzhe.contest.biweeekly.s1.biweekly27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/5/30
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_2703 {
    //Map<Integer, Set<Integer>> map = new HashMap<>();
    Set<Integer>[] map = new Set[100];

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            map[i] = new HashSet<>();
        }

        for (int[] prerequisite : prerequisites) {
            map[prerequisite[0]].add(prerequisite[1]);
        }
        for (int[] query : queries) {
            res.add(dfs(query[0], query[1], new boolean[n]));
        }
        return res;

    }

    private Boolean dfs(int start, int end, boolean[] visited) {
        Set<Integer> set = map[start];
        if (set.size() == 0) return false;
        visited[start] = true;
        boolean flag = false;
        for (Integer i : set) {
            if (i == end) return true;
            if (!visited[i]) {
                flag = flag || dfs(i, end, visited);
            }
        }
        return flag;

    }

}
