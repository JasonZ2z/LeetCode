package com.xinzhe.categories.solutions.slidingwindow.medium;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/1 15:20
 * Title : 209. 长度最小的子数组
 * Description : 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 * link : https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * Level : medium
 */
public class Leetcode209 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 1};
        System.out.println(minSubArrayLen(7, nums));
        System.out.println(minSubArrayLen2(7, nums));
    }

    //滑动窗口
    private static int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0, sum = 0, result = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //暴力
    private static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (Arrays.stream(nums).sum() < s) return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int sum = 0;
            while (sum < s && j < nums.length) {
                sum += nums[j++];
            }
            result = sum >= s ? Math.min(result, j - i) : result;
        }
        return result;
    }

}
