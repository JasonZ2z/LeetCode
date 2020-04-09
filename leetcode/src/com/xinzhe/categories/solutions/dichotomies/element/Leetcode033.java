package com.xinzhe.categories.solutions.dichotomies.element;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 33. 搜索旋转排序数组
 * Description : 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *          搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。
 * link : https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * Level : Medium
 */

public class Leetcode033 {
    // 0 1 2 3 50 51 52 100
    // 51 52 100 0 1 2 3 7 8 9 10   0
    // 10 11 12 13 14 15 16 1 2
    // 10 11 12 1 2 3 4 5 6 7
    // x - y  > x - y -1
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        System.out.println(search(arr, 100));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target) return mid;
            //左半边有序
            if(nums[mid] >= nums[left]){
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
        return -1;
    }

}
