package com.xinzhe.contest.weekly.season04.weekly191;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/5/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 191周赛01
 */
public class Leetcode_weekly_19101 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

}
