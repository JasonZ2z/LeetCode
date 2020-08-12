package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @author Xin
 * @date 2020/3/17 21:00
 * Title : 136. 只出现一次的数字
 * Description : 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * link : https://leetcode-cn.com/problems/single-number/
 * Level : Easy
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
