package com.xinzhe.categories.structure.arrays.medium;

/**
 * @author Xin
 * @date 2020/8/31
 * Title : 238. 除自身以外数组的乘积
 * Description : 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * link : https://leetcode-cn.com/problems/product-of-array-except-self
 * Level : Medium
 */
//说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 2) {
            res[0] = nums[1];
            res[1] = nums[0];
            return res;
        }
        res[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            res[i] = res[i+1] * nums[i+1];
        }
        int pre = 1;
        for(int i=0; i<n; i++) {
            res[i] *= pre;
            pre *= nums[i];
        }
        return res;
    }
}
