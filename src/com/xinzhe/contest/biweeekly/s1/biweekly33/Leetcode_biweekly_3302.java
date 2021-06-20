package com.xinzhe.contest.biweeekly.s1.biweekly33;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/22
 * Title : 1557. 可以到达所有点的最少点数目
 * Description : 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 *              找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。你可以以任意顺序返回这些节点编号。
 * link : https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes
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
