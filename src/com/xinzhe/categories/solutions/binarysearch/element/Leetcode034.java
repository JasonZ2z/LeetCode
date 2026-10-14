package com.xinzhe.categories.solutions.binarysearch.element;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 34. 在排序数组中查找元素的第一个和最后一个位置
 * Description : 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
 * link : https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * Level : Medium
 */

public class Leetcode034 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(arr, 11)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        int last = lowerBound(nums, target + 1) - 1;
        return new int[]{first, last};
    }

    // 返回第一个 >= target 的下标；若都不满足则返回 nums.length
    private static int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
