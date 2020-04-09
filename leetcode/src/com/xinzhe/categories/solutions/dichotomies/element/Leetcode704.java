package com.xinzhe.categories.solutions.dichotomies.element;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 704. 二分查找
 * Description : 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * link : https://leetcode-cn.com/problems/binary-search
 * Level : Easy
 */

public class Leetcode704 {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr, -5));
        System.out.println(search2(arr, -4));
        System.out.println(search3(arr, -2));
    }
    //左闭右闭
    //终止条件: left == right
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int left = 0, right = n-1;
        while(left < right){

            int mid =  left + ((right - left) >> 1);
            System.out.println(left + " " + right + " " + mid);
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
    //左闭右闭
    //终止条件: left > right
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int left = 0, right = n-1;
        while(left <= right){

            int mid =  left + ((right - left) >> 1);
            System.out.println(left + " " + right + " " + mid);
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid-1;
            } else {
                return left;
            }
        }
        return -1;
    }

    //左闭右开
    //终止条件: left == right
    public static int search3(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int left = 0, right = n;
        while (left < right) {

            int mid = left + ((right - left) >> 1);
            System.out.println(left + " " + right + " " + mid);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == n) return -1;
        return nums[left] == target ? left : -1;
    }
}
