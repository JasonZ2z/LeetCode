package com.xinzhe.categories.solutions.slidingwindow.consecutive;

/**
 * @Author Xin
 * @create 2020/6/3
 * Title : 487. Max Consecutive Ones II
 * Description : Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * link : https://leetcode-cn.com/problems/max-consecutive-ones-ii/
 * Level : Medium
 */
public class Leetcode487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, count = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) count++;
            while (count > 1) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
