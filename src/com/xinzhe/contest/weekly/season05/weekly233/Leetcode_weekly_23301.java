package com.xinzhe.contest.weekly.season05.weekly233;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23301 {
    public static void main(String[] args) {
        Leetcode_weekly_23301 lc = new Leetcode_weekly_23301();

    }

    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                cur += nums[i];
            } else {
                max = Math.max(max, cur);
                cur =  nums[i];
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
