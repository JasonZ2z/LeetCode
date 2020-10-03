package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.HashMap;

/**
 * @author Xin
 * @date 2020/3/11 18:45
 * Title : 873. 最长的斐波那契子序列的长度
 * Description : 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *              n >= 3
 *              对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 *              给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * link : https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
 * Level : Medium
 */
public class Leetcode873 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(arr));
    }
    public static int lenLongestFibSubseq(int[] A) {
        if(A.length <= 0) return 0;
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = 2;

            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0; j--) {
                int tmp = A[i] - A[j];
                if(map.containsKey(tmp)){
                    int k = map.get(tmp);
                    dp[j][i] = Math.max(dp[k][j] + 1, dp[j][i]);

                }
                max = Math.max(max, dp[j][i]);
            }
        }
        return max > 2 ? max : 0;
    }
}
