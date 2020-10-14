package com.xinzhe.categories.structure.arrays.easy;

/**
 * @author Xin
 * @date 2020/10/14
 * Title : 169. 多数元素
 * Description : 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *              你可以假设数组是非空的，并且给定的数组总是存在多数元素。。
 * link : https://leetcode-cn.com/problems/majority-element
 * Level : Easy
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int c = 1, pre = nums[0];
        for(int i =1; i<nums.length; i++) {
            if(nums[i] == pre) c++;
            else{
                c--;
                if(c == 0) {
                    c = 1;
                    pre = nums[i];
                }
            }
        }
        return pre;
    }
}
