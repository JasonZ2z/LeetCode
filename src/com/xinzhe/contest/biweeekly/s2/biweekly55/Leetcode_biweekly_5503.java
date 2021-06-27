package com.xinzhe.contest.biweeekly.s2.biweekly55;

/**
 * @author Xin
 * @date 2021/06/26
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5503 {
    public static void main(String[] args) {
        Leetcode_biweekly_5503 lc = new Leetcode_biweekly_5503();
        int[] arr = {4,2,5,3};
        int[] arr2 = {6,2,1,2,4,5};
        System.out.println(lc.maxAlternatingSum(arr2));
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];

        dp[0][1] = nums[0];
        long max = 0;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.min(dp[i-1][0], Math.min(nums[i], nums[i] - dp[i-1][1]));
            dp[i][1] = Math.max(nums[i], Math.max(dp[i-1][1], nums[i] - dp[i-1][0]));
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}