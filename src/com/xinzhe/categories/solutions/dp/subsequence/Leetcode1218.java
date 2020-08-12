package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Xin
 * @create 2020/3/11 18:35
 * Title : 1218. 最长定差子序列
 * Description : 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 * link : https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * Level : Medium
 */
public class Leetcode1218 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        System.out.println(longestSubsequence(arr, 1));
        System.out.println(longestSubsequence2(arr, 1));
    }
    public static int longestSubsequence2(int[] arr, int difference) {
        if(arr.length < 2) return 0;
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            Integer val = map.get(value - difference);
            if (val != null) {
                map.put(value, val + 1);
                max = Math.max(max, val + 1);
            } else {
                map.put(value, 1);
            }
        }
        return max;
    }

    //dp超时
    public static int longestSubsequence(int[] arr, int difference) {
        if(arr.length < 2) return 0;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] - arr[j] == difference){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
