package com.xinzhe.contest.biweeekly.biweekly40;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/28
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_4004 {
    public static void main(String[] args) {
        Leetcode_biweekly_4004 lc = new Leetcode_biweekly_4004();
        int[] arr = {1,3,1};
        System.out.println(lc.minimumMountainRemovals(arr));
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int min = n;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        for(int i=0; i<n; i++) {
            for (int j = i-1; j >=0; j--) {
                if(nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for(int i=n-1; i>=0; i--) {
            for (int j = i+1; j <n; j++) {
                if(nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        for (int i = 1; i < n-1 ; ++i) {
            min = Math.min(min, n - (dp1[i] + dp2[i] -1));
        }
        return min;
    }
}