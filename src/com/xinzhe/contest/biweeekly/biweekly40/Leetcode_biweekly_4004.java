package com.xinzhe.contest.biweeekly.biweekly40;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/28
 * Title : 1671. 得到山形数组的最少删除次数
 * Description : 我们定义arr是 山形数组当且仅当它满足：arr.length >= 3
 *              存在某个下标i（从 0 开始）满足0 < i < arr.length - 1且：
 *              arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *              arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *              给你整数数组nums ，请你返回将 nums变成 山形状数组的 最少删除次数。
 * link : https://leetcode-cn.com/problems/minimum-number-of-removals-to-make-mountain-array
 * Level : Hard
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