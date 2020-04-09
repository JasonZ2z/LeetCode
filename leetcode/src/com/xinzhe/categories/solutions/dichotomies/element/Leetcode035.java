package com.xinzhe.categories.solutions.dichotomies.element;

/**
 * @author Xin
 * @date 2020/4/7 17:53
 * Title : 35. 搜索插入位置
 * Description : 编给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。你可以假设数组中无重复元素。
 * link : https://leetcode-cn.com/problems/search-insert-position/
 * Level : Easy
 */
public class Leetcode035 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7};
        System.out.println(searchInsert(nums,8));
    }
    //二分法
    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(nums[0] > target) return 0;
        if(nums[n-1] < target) return n;
        int left = 0, right = n-1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left + " " + right) ;
        if(nums[left] == target) return left;
        return left+1;
    }
}
