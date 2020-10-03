package com.xinzhe.contest.weekly.season03.weekly136;

import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1042. 不邻接植花
 * Description : 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *              另外，没有花园有 3 条以上的路径可以进入或者离开。你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *              以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 * link : https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
 * Level : Easy
 */

// 此题之所以为Easy, 是因为限定 "没有花园有 3 条以上的路径可以进入或者离开"
public class Leetcode_weekly_13602 {
    public static void main(String[] args) {
        Leetcode_weekly_13602 lc = new Leetcode_weekly_13602();
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        HashSet<Integer>[] graph = new HashSet[n+1];
        for(int i=0; i<=n; i++) graph[i] = new HashSet<>();
        for(int[] p : paths) {
            int s = p[0], e = p[1];
            graph[s].add(e);
            graph[e].add(s);
        }
        int[] dp = new int[n];
        for(int i=1; i<=n; i++) {
            boolean[] color = new boolean[5];
            for(int j : graph[i]) {
                color[dp[j-1]] = true;
            }
            for(int j=1; j<=4; j++) {
                if(!color[j]){
                    dp[i-1] = j;
                    break;
                }
            }
        }
        return dp;
    }

}
