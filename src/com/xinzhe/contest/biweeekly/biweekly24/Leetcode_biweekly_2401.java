package com.xinzhe.contest.biweeekly.biweekly24;

/**
 * @author Xin
 * @date 2020/4/18 22:16
 * Title : 5372. 逐步求和得到正数的最小值
 * Description : 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 *              你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 *              请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * link : https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * Level : Easy
 * Comment : 24双周赛01
 */
public class Leetcode_biweekly_2401 {
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
        for (int num : nums) {
            min = Math.min(min, num);
        }
        if(min > 0) return 1;
        else return 1-min;
    }
}
