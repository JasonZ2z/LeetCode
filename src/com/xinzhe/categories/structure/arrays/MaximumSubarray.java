package com.xinzhe.categories.structure.arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum, sum + num);
            max = Math.max(sum, max);
        }
        return max;
    }
}
