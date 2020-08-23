package com.xinzhe.contest.biweeekly.biweekly33;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/22
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_3302 {
    public static void main(String[] args) {
        Leetcode_biweekly_3302 lc = new Leetcode_biweekly_3302();
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if(inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
