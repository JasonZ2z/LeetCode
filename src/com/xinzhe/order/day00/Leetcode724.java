package com.xinzhe.order.day00;

/**
 * @author Xin
 * @date 2020/2/25 10:57
 * Title : 724. 寻找数组的中心索引
 * Description : 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *              我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *              如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。。
 * link : https://leetcode-cn.com/problems/find-pivot-index
 * Level : easy
 */
public class Leetcode724 {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            int left = sum(nums, 0, i);
            int right =  sum(nums, i+1, nums.length);
            if(left == right){
                return i;
            }
        }
        return -1;
    }

    public static int sum(int[] nums, int start, int end){
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
