package com.xinzhe.categories.solutions.binarysearch.element;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 34. 在排序数组中查找元素的第一个和最后一个位置
 * Description : 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *      你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
 * link : https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * Level : Medium
 */

public class Leetcode034 {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 11)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[]{-1,-1};
        int left = 0, right = n-1;
        int i=0,j=0;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid +1;
                i = mid;
                while (i >= 0 && nums[i] == target){
                    i--;
                }
                j = mid;
                while (j < n && nums[j] == target){
                    j++;
                }
            }
        }
        if(i == n || j == 0) return new int[]{-1,-1};
        return new int[]{i+1, j-1};
    }

    public int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[]{-1,-1};
        if(n == 1) {
            if(nums[0] == target) return new int[]{0,0};
            else return new int[]{-1,-1};
        }
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + ((right - left)/2);
            if(nums[mid] == target){
                int  p = mid-1, q = mid+1;
                while(p>=0 && nums[p]==target) p--;
                while(q<n && nums[q]==target) q++;
                return new int[]{p+1, q-1};
            } else if(nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        if(left < n && nums[left] == target) return new int[]{left, left};
        return new int[]{-1,-1};
    }
}
