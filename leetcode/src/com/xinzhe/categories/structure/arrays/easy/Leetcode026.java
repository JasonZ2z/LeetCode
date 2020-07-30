package com.xinzhe.categories.structure.arrays.easy;

/**
 * @Author Xin
 * @create 2020/7/30
 * Title : 26. 删除排序数组中的重复项
 * Description : 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *              不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * link : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * Level : Easy
 */
public class Leetcode026 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int i=0, j=1;
        while(j < n){
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
