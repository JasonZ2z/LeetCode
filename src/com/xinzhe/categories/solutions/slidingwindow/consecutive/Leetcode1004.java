package com.xinzhe.categories.solutions.slidingwindow.consecutive;

/**
 * @author Xin
 * @date 2020/6/3
 * Title : 1004. 最大连续1的个数 III
 * Description : 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。返回仅包含 1 的最长（连续）子数组的长度。
 * link : https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * Level : Medium
 */
public class Leetcode1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int count = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == 0) count++;
            while (count > k) {
                if (nums[i++] == 0) count--;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
