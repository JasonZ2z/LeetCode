package com.xinzhe.contest.weekly.season04.weekly195;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/6/28
 * Title : 1498. 满足条件的子序列数目
 * Description : 给你一个整数数组 nums 和一个整数 target 。请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
 * link : https://leetcode-cn.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
 * Level : Medium
 * Comment 195周赛03
 * tag : 快速幂， 二分， 双指针
 */
public class Leetcode_weekly_19503 {
    public static void main(String[] args) {
        int[] arr = {3,5,6,7};
        System.out.println(numSubseq(arr, 9));
    }
    static final int MOD = (int)(1e9 + 7);
    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0L;
        int[] dp = new int[n+1];
        //快速幂
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = 2 * dp[i-1] % MOD;
        }
        //双指针
        int left = 0, right = n-1;
        while ( left <= right) {
            if(nums[left] + nums[right] <= target) {
                count = (count + dp[right-left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return (int) (count % MOD);
    }
}
