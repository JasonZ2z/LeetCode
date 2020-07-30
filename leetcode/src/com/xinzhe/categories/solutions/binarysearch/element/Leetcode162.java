package com.xinzhe.categories.solutions.binarysearch.element;

/**
 * @Author Xin
 * @create 2020/4/14 21:41
 * Title : 162. 寻找峰值
 * Description : 峰值元素是指其值大于左右相邻值的元素。给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *              数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。你可以假设 nums[-1] = nums[n] = -∞。
 * Level : Medium
 */

public class Leetcode162 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr2 = {5};
        System.out.println(findPeakElement(arr));
        System.out.println(findPeakElement(arr2));
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(mid - 1 >= 0 && mid + 1 < n){
                if(nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1]){
                    return mid;
                } else if(nums[mid] > nums[mid -1] && nums[mid] < nums[mid+1]){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if(nums[mid] > nums[mid + 1]){
                return mid;
            } else {
                return mid+1;
            }
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        int l = 0, r = n -1;
        while(l < r) {
            int mid = l + ((r-l) >> 1);
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return r;
    }
}
