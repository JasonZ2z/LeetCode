package com.xinzhe.contest.weekly.weekly166;

/**
 * @Author Xin
 * @create 2020/6/08
 * Title : 1283. 使结果不超过阈值的最小除数
 * Description : 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。题目保证一定有解。
 * link : https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold
 * Level : Medium
 * Comment 166周赛03
 */

public class Leetcode_weekly_16603 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) 1e6;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (ok(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (ok(nums, left, threshold)) return left;
        return -1;
    }

    private boolean ok(int[] nums, int mid, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / mid);
        }
        return sum <= threshold;

    }

    public static void main(String[] args) {
        System.out.println((int) 1e6);
        System.out.println((int) Math.ceil((double) 7 / 3));
    }

}
