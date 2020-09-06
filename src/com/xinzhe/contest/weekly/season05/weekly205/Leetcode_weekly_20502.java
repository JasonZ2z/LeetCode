package com.xinzhe.contest.weekly.season05.weekly205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/6
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_20502 {
    public static void main(String[] args) {
        Leetcode_weekly_20502 lc = new Leetcode_weekly_20502();
        int[] arr = {43024,99908};
        int[] arr2 = {1864};
        System.out.println(lc.numTriplets(arr, arr2));
    }
    public int numTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        long[] num1 = new long[n];
        long[] num2 = new long[m];

        long[] n1 = new long[n];
        long[] n2 = new long[m];

        for (int i = 0; i < n; i++) {
            num1[i] = nums1[i];
            n1[i] = num1[i] * num1[i];
        }

        for (int i = 0; i < m; i++) {
            num2[i] = nums2[i];
            n2[i] = num2[i] * num2[i];
        }

        Map<Long, Integer> m1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; ++j) {
                m1.put(num1[i] * num1[j], m1.getOrDefault(num1[i] * num1[j], 0) + 1);
            }
        }
        Map<Long, Integer> m2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; ++j) {
                m2.put(num2[i] * num2[j], m2.getOrDefault(num2[i] * num2[j], 0) + 1);
            }
        }
        int res = 0;
        for (long i : n1) {
            res += m2.getOrDefault(i, 0);
        }
        for (long i : n2) {
            res += m1.getOrDefault(i, 0);
        }
        return res;

    }
}
