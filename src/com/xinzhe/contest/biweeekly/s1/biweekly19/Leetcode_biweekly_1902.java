package com.xinzhe.contest.biweeekly.s1.biweekly19;

/**
 * @author Xin
 * @date 2020/5/20
 * Title : 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * Description : 给你一个整数数组 arr 和两个整数 k 和 threshold 。请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * link : https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 * Level : Medium
 * Comment 19双周赛02
 */

public class Leetcode_biweekly_1902 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;

        if (k == n) return 1;
        int[] pre = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        int count = 0;
        for (int i = k - 1; i < n; ++i) {
            int sum = (pre[i + 1] - pre[i + 1 - k]) / k;
            if (sum >= threshold) {
                count++;
            }
        }
        return count;
    }
}
