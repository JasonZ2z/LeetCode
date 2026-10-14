package com.xinzhe.categories.solutions.binarysearch.function;

/**
 * @author Xin
 * @date 2020/4/6 21:41
 * Title : 4. 寻找两个有序数组的中位数
 * Description : 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。你可以假设 nums1 和 nums2 不会同时为空
 * link : https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * Level : Hard
 */
//todo need to review
public class Leetcode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {                 // 让 nums1 是较短的那个
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int l = 0, r = m;
        int i = 0, j = 0;
        while (l <= r) {
            i = l + (r - l) / 2;
            j = totalLeft - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                r = i - 1;   // nums1 进左半的太多 → i 变小
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                l = i + 1;   // nums1 进左半的太少 → i 变大
            } else break;                                              // 切对了
        }

        int leftMax1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int leftMax2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int rightMin1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int rightMin2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

        int leftMax = Math.max(leftMax1, leftMax2);
        if (((m + n) & 1) == 1) return leftMax;
        return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
    }
}
