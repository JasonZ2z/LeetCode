package com.xinzhe.contest.weekly.season06.weekly255;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/08/22
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25501 {
    public static void main(String[] args) {
        Leetcode_weekly_25501 lc = new Leetcode_weekly_25501();

    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length - 1]);
    }

    public int gcd(int m, int n) {
        int result;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }
}
