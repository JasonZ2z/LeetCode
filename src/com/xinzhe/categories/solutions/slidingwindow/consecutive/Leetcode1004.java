package com.xinzhe.categories.solutions.slidingwindow.consecutive;

/**
 * @Author Xin
 * @create 2020/6/3
 * Title : 1004. 最大连续1的个数 III
 * Description : 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。返回仅包含 1 的最长（连续）子数组的长度。
 * link : https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * Level : Medium
 */
public class Leetcode1004 {
    public int longestOnes(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        if (k >= n) return n;

        int count0 = 0;
        int max = 0;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0) count0++;
            while (count0 > k) {
                if (arr[start] == 0) {
                    count0--;
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
