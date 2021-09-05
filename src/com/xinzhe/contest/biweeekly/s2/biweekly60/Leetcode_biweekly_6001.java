package com.xinzhe.contest.biweeekly.s2.biweekly60;

/**
 * @author Xin
 * @date 2021/09/04
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6001 {
    public static void main(String[] args) {
        Leetcode_biweekly_6001 lc = new Leetcode_biweekly_6001();

    }

    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n+1];
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            left[i+1] = left[i] + nums[i];
            sum += nums[i];
        }

        for (int i = 0; i < n; ++i) {
            if(left[i] * 2 == sum - nums[i]) return i;
        }
        return -1;
    }
}