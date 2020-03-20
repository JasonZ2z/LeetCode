package com.xinzhe.categories.bitoperation;

/**
 * @Author Xin
 * @create 2020/3/17 21:00
 * Title : 137. 只出现一次的数字 II
 * Description : 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * link : https://leetcode-cn.com/problems/single-number-ii/
 * Level : Medium
 */
public class Leetcode137 {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
