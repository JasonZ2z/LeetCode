package com.xinzhe.contest.weekly.season05.weekly248;

/**
 * @author Xin
 * @date 2021/07/04
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24801 {
    public static void main(String[] args) {
        Leetcode_weekly_24801 lc = new Leetcode_weekly_24801();

    }
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
