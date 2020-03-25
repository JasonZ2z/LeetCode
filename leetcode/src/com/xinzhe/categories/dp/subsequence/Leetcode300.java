package com.xinzhe.categories.dp.subsequence;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/11 18:25
 * Title : 300. 最长上升子序列
 * Description : 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * link : https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Level : Medium
 */
public class Leetcode300 {
    public static void main(String[] args) {
        int[] arr = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(arr));
    }
    //以 nums[i] 为结尾的最长递增子序列
    private static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 1; i<n; ++i){
            for(int j =i-1; j>=0; --j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] +1 ,dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
