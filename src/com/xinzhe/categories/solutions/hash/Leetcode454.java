package com.xinzhe.categories.solutions.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/15
 * Title : 454. 四数相加 II
 * Description : 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * link : https://leetcode-cn.com/problems/4sum-ii
 * Level : Medium
 */

public class Leetcode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0 - C[i] - D[j];
                if (map.containsKey(tmp)) {
                    res += map.get(tmp);
                }
            }
        }
        return res;
    }
}
