package com.xinzhe.contest.biweeekly.biweekly47;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/03/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4704 {
    public static void main(String[] args) {
        Leetcode_biweekly_4704 lc = new Leetcode_biweekly_4704();
        int[] arr = {2, 4, 9, 3};
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int len = queries.length;
        int[] res = new int[len];
        int[][] dp = new int[n][n];

        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            dp[i][j]++;
            dp[j][i]++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return res;
    }
}