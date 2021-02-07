package com.xinzhe.contest.weekly.season05.weekly227;

/**
 * @author Xin
 * @date 2021/02/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22701 {
    public static void main(String[] args) {
        Leetcode_weekly_22701 lc = new Leetcode_weekly_22701();
    }
    public boolean check(int[] nums) {
        int  min = nums[0], max = nums[0];
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
           if(nums[i] >= nums[i-1]) {
               if(!flag) {
                   max = Math.max(max, nums[i]);
               } else {
                   if(nums[i] > min) return false;
               }
           } else {
               if(!flag) {
                   if(nums[i] > min) return false;
                    flag = true;
               } else {
                    return false;
               }
           }
        }
        return true;
    }
}
