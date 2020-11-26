package com.xinzhe.categories.solutions.binarysearch.element;

/**
 * @author Xin
 * @date 2020/4/9 15:56
 * Title : 540. 有序数组中的单一元素
 * Description : 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * link : https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * Level : Medium
 */
//todo need to review
public class Leetcode540 {
    public static void main(String[] args) {
        //int[] arr = {1,1,2,3,3,4,4,8,8};
        int[] arr = {3,3,7,7,10,11,11};
        Leetcode540 lc = new Leetcode540();
        System.out.println(lc.singleNonDuplicate(arr));
    }
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l < r) {
            int mid = l + r >> 1;
            if(nums[mid] == nums[mid + 1]) {
                if((mid - l) % 2 == 0) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            } else {
                if((r - mid) % 2 == 0) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }
}