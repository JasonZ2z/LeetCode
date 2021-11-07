package com.xinzhe.contest.weekly.season06.weekly265;

/**
 * @author Xin
 * @date 2021/10/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26501 {
    public static void main(String[] args) {
        Leetcode_weekly_26501 lc = new Leetcode_weekly_26501();

    }
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if( i % 10 == nums[i]) return i;
        }
        return -1;
    }
}
