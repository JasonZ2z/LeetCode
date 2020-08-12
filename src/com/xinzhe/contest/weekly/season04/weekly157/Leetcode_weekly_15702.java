package com.xinzhe.contest.weekly.season04.weekly157;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/7/16
 * Title : 1218. 最长定差子序列
 * Description : 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 * link : https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * Level : Medium
 * Comment 157周赛02
 */

public class Leetcode_weekly_15702 {

    public static void main(String[] args) {
        Leetcode_weekly_15702 lc = new Leetcode_weekly_15702();
        int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        System.out.println(lc.longestSubsequence(arr, 0));
    }

    //dp 时间复杂度n2 依旧超时
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; ++i) {
            for(int j = i-1; j >= 0; --j) {
                if(arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int longestSubsequence2(int[] arr, int difference) {
        int n = arr.length;
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i : arr) {
            if(map.containsKey(i)) {
                max = Math.max(max, map.get(i)+1);
                map.put(i+difference, map.get(i)+1);
            } else {
                map.put(i+difference, 1);
            }
        }
        return max;
    }

}
