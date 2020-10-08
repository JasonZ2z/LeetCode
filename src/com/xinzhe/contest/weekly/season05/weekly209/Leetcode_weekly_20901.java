package com.xinzhe.contest.weekly.season05.weekly209;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/4
 * Title : 1608. 特殊数组的特征值
 * Description : 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *              注意： x 不必 是 nums 的中的元素。如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * link : https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 * Level : Easy
 */
public class Leetcode_weekly_20901 {
    public static void main(String[] args) {
        Leetcode_weekly_20901 lc = new Leetcode_weekly_20901();
        int[] arr = {3,5};
        System.out.println(lc.specialArray(arr));
    }
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);


        for (int i = 0; i < nums[n-1] + 1; ++i) {
            int c =  0;
            for (int num : nums) {
                if (num >= i) {
                    c++;
                    if (c > i) break;
                }
            }
            if(c == i) return i;

        }
        return -1;
    }
}
