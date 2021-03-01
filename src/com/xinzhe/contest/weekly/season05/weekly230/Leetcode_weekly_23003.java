package com.xinzhe.contest.weekly.season05.weekly230;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/02/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Tag : 贪心
 */
//todo need to review
public class Leetcode_weekly_23003 {
    public static void main(String[] args) {
        Leetcode_weekly_23003 lc = new Leetcode_weekly_23003();
        int[] arr1 = {6,6};
        int[] arr2 = {1};
        System.out.println(lc.minOperations(arr1, arr2));
    }
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n * 6 || n > m * 6) return -1;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if(sum1 == sum2) return 0;
        if(sum2 < sum1) return minOperations(nums2, nums1);

        int[] bucket = new int[7];

        for (int k : nums1) bucket[6 - k]++;
        for (int k : nums2) bucket[k - 1]++;
        int diff = sum2 - sum1;

        int count =  0;
        for(int i = 5; i > 0; --i) {
            while (diff > 0 && bucket[i] > 0) {
                bucket[i]--;
                diff -= i;
                count++;
            }
        }
        return diff <= 0? count : -1;
    }
}
