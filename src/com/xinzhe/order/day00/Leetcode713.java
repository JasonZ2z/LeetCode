package com.xinzhe.order.day00;

/**
 * @author Xin
 * @date 2020/2/26 13:53
 * Title : 713. 乘积小于K的子数组
 * Description : 给定一个正整数数组 nums。找出该数组内乘积小于 k 的连续的子数组的个数。
 * link : https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * Level : medium
 */
public class Leetcode713 {

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }
    //双指针
    //计算包含最右边的数字的子串数量
    //right-left +1
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(k < 2) return 0;
        int count = 0;
        int left = 0;
        long tmp = 1L;
        for (int right = 0; right < nums.length; right++) {
            tmp *= nums[right];
            while (tmp >= k){
                tmp /= nums[left++];
            }
            count += right - left +1;
        }
        return count;
    }
}
