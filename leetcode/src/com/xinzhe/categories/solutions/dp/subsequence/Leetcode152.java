package com.xinzhe.categories.solutions.dp.subsequence;

/**
 * @Author Xin
 * @create 2020/3/9 21:44
 * Title : 152. 乘积最大子序列
 * Description : 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * link : https://leetcode-cn.com/problems/maximum-product-subarray/
 * Level : Medium
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        if(nums.length < 1) return 0;
        int n = nums.length;
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] < 0){
                int tmp = dpmin[i-1];
                dpmin[i-1] = dpmax[i-1];
                dpmax[i-1] = tmp;
            }
            dpmax[i] = Math.max(dpmax[i-1]*nums[i], nums[i]);
            dpmin[i] = Math.min(dpmin[i-1]*nums[i], nums[i]);
            max = Math.max(dpmax[i], max);
        }
        return max;
    }
}
