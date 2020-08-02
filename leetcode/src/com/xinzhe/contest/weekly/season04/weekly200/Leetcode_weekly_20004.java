package com.xinzhe.contest.weekly.season04.weekly200;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20004 {
    public static void main(String[] args) {
        Leetcode_weekly_20004 lc = new Leetcode_weekly_20004();
    }
    public int maxSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long res = 0;
        int p = 0, q = 0;
        long ps = 0, qs = 0;
        while (p < n1 || q < n2) {
            ps += nums1[p];
            qs += nums2[q];

            if(nums1[p] == nums2[q]) {

            }
        }
        return 0;
    }
}
