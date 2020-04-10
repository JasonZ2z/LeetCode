package com.xinzhe.categories.solutions.binarysearch.element;


/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 153. 寻找旋转排序数组中的最小值
 * Description : 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *              请找出其中最小的元素。你可以假设数组中不存在重复元素。
 * link : https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * Level : Medium
 */

public class Leetcode153 {
    //0,0,0,0,0,1
    //0,1,1,1,1,1
    //1,0,0,0,0,0
    //1,2,3,3,0,1
    //1,1,1,1,1,0
    //2,3,4,5,6,1
    //6,1,2,3,4,5
    //12,13,14,15,1;
    public static void main(String[] args) {
        int[] arr = {12,13,14,15,1};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == nums[left]){
                if(left + 1 == right){
                    return Math.min(nums[left], nums[right]);
                } else {
                    left++;
                }
            } else if(nums[mid] > nums[left]){
                if(nums[left] < nums[right]){
                    return nums[left];
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
