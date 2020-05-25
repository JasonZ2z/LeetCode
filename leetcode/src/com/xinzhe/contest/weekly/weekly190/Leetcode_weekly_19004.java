package com.xinzhe.contest.weekly.weekly190;

/**
 * @Author Xin
 * @create 2020/5/24
 * Title : 1458. 两个子序列的最大点积
 * Description : 给你两个数组 nums1 和 nums2 。请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *              数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 * link : https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
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
