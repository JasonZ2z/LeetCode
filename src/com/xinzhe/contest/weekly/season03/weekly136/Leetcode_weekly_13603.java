package com.xinzhe.contest.weekly.season03.weekly136;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1043. 分隔数组以得到最大和
 * Description : 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。返回给定数组完成分隔后的最大和。
 * link : https://leetcode-cn.com/problems/partition-array-for-maximum-sum
 * Level : Medium
 */

public class Leetcode_weekly_13603 {
    public static void main(String[] args) {
        Leetcode_weekly_13603 lc = new Leetcode_weekly_13603();
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(lc.maxSumAfterPartitioning(arr, 3));
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(k == 1) return Arrays.stream(arr).sum();
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            int max = 0;
            for(int j = i; j >=0 && i-j < k; j--) {
                max = Math.max(max, arr[j]);
                dp[i+1] = Math.max(dp[i+1], dp[j] + (i-j+1) * max);
            }
        }
        return dp[n];
    }
}
