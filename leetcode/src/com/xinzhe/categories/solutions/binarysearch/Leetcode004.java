package com.xinzhe.categories.solutions.binarysearch;

/**
 * @Author Xin
 * @create 2020/4/6 21:41
 * Title : 4. 寻找两个有序数组的中位数
 * Description : 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *      请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *      你可以假设 nums1 和 nums2 不会同时为空
 * link : https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * Level : Hard
 */
//todo undo
public class Leetcode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 == 0) {
            if(n2 % 2 == 0){
                return (double)(nums2[n2/2] + nums2[n2/2 -1])/2;
            } else {
                return (double)nums2[n2/2];
            }
        }
        if(n2 == 0) {
            if(n1 % 2 == 0){
                return (double)(nums1[n1/2] + nums1[n1/2 -1])/2;
            } else {
                return (double)nums1[n1/2];
            }
        }
        return 0.0;

    }
}
