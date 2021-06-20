package com.xinzhe.contest.biweeekly.s1.biweekly50;

/**
 * @author Xin
 * @date 2021/04/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5001 {
    public static void main(String[] args) {
        Leetcode_biweekly_5001 lc = new Leetcode_biweekly_5001();
    }
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) continue;
            count += nums[i-1] + 1 -  nums[i];
            nums[i] = nums[i-1] + 1;
        }
        return count;
    }
}