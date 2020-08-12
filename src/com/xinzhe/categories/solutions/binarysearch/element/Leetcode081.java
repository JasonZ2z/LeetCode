package com.xinzhe.categories.solutions.binarysearch.element;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 81. 搜索旋转排序数组 II
 * Description : 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *              ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *              编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false
 * link : https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * Level : Medium
 */

public class Leetcode081 {

    public static void main(String[] args) {
        int[] arr = {1,3,1,1,1};
        System.out.println(search(arr, 3));
    }
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return false;
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target) return true;
            //左半边有序
            if(nums[mid] == nums[left]){
                left++;
            } else if(nums[mid] > nums[left]){
                if(target < nums[mid] && target >= nums[left]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
                //右半边有序
            } else {
                if(target > nums[mid] && target < nums[left]){
                    left = mid +1;
                } else {
                    right = mid -1;
                }
            }
        }
        return false;
    }

}
