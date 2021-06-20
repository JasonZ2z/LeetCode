package com.xinzhe.contest.biweeekly.s1.biweekly45;

/**
 * @author Xin
 * @date 2021/02/05
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4502 {
    public static void main(String[] args) {
        Leetcode_biweekly_4502 lc = new Leetcode_biweekly_4502();
        int[] arr = {2, 4, 9, 3};
    }
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = Math.max(nums[0], 0);
        dp[0][1] = Math.min(nums[0], 0);

        int max = Math.abs(nums[0]);
        for (int i = 1; i < n; ++i) {
            if(nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i-1][0] + nums[i], nums[i]);
                dp[i][1] = dp[i-1][1] + nums[i];
            } else {
                dp[i][0] = dp[i-1][0] + nums[i];
                dp[i][1] = Math.min(dp[i-1][1] + nums[i], nums[i]);
            }
            max = Math.max(max, Math.max(Math.abs(dp[i][0]), Math.abs(dp[i][1])));
        }
        return max;
    }
}