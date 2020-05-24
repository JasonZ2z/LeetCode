package com.xinzhe.contest.weekly.weekly190;

/**
 * @Author Xin
 * @create 2020/5/24
 * Title :
 * Description :
 * link :
 * Level : Hard
 * Comment 190周赛04
 */
public class Leetcode_weekly_19004 {
    public static void main(String[] args) {
        int[] n1 = {-5, 3, -5, -3, 1};
        int[] n2 = {-2, 4, 2, 5, -5};
        System.out.println(maxDotProduct(n1, n2));

    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
