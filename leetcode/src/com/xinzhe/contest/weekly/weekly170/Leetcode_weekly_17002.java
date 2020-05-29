package com.xinzhe.contest.weekly.weekly170;

/**
 * @Author Xin
 * @create 2020/5/27
 * Title : 1310. 子数组异或查询
 * Description : 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *          对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *          并返回一个包含给定查询 queries 所有结果的数组。
 * link : https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * Level : Medium
 * Comment 170周赛02
 */

public class Leetcode_weekly_17002 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; ++j) {
                res[i] ^= arr[j];
            }
        }
        return res;

    }

}
