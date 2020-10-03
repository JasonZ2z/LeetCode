package com.xinzhe.categories.solutions.binarysearch.function;

/**
 * @author Xin
 * @date 2020/4/6 21:41
 * Title : 4. 寻找两个有序数组的中位数
 * Description : 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *      请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。你可以假设 nums1 和 nums2 不会同时为空
 * link : https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * Level : Hard
 */
//todo need to review
public class Leetcode004 {
    // O(n) : log(m+n)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        if((k & 1) == 1) {
            return find(nums1, 0, nums2, 0, k / 2 + 1);
        } else {
            int left = find(nums1, 0, nums2, 0, k / 2);
            int right = find(nums1, 0, nums2, 0, k / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    private int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if(nums1.length - i > nums2.length - j) return find(nums2 ,j, nums1, i, k);
        if(k == 1) {
            if(i == nums1.length - 1) return nums2[j];
            else return Math.min(nums1[i], nums2[j]);
        }
        if(i == nums1.length -1) return nums2[j + k - 1];
        int si = Math.min(i + k/2, nums1.length-1);
        int sj = j + k - k/2;
        if(nums1[si - 1] > nums2[sj - 1]) {
            return find(nums1, i, nums2, sj, k - (sj - j));
        } else {
            return find(nums1, si, nums2, j, k - (si - i));
        }
    }


    // O(n) : log(min(m,n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1); // make sure n1 < n2
        if (n1 == 0) {
            return n2 % 2 == 0 ? (double) (nums2[n2 / 2] + nums2[n2 / 2 - 1]) / 2 : nums2[n2 / 2];
        }
        int len = n1 + n2; // total length
        int left = 0, right = n1; //
        int mid1 = 0; //first cut point

        while (mid1 <= n1) {
            mid1 = left + (right - left) / 2;
            int mid2 = len / 2 - mid1;
            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            double r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            double r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];
            if (l1 > r2) {
                right = mid1 - 1;
            } else if (l2 > r1) {
                left = mid1 + 1;
            } else {
                if(len % 2 == 0){
                    l1 = Math.max(l1, l2);
                    r1 = Math.min(r1, r2);
                    return (l1 + r1)/2;
                } else {
                    return Math.min(r1, r2);
                }
            }
        }
        return -1;
    }
}
