package com.xinzhe.contest.biweeekly.s2.biweekly61;

/**
 * @author Xin
 * @date 2021/09/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6101 {
    public static void main(String[] args) {
        Leetcode_biweekly_6101 lc = new Leetcode_biweekly_6101();

    }
    public int countKDifference(int[] nums, int k) {
        int count =  0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }
        return count;
    }
}