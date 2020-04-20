package com.xinzhe.order.day10;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_dweekly_2401 {
    public static void main(String[] args) {
        int[] a = {1,-2,-3};
        System.out.println(minStartValue(a));
    }
    public static int minStartValue(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, nums[i]);
        }
        if(min > 0) return 1;
        else return 1-min;
    }
}
