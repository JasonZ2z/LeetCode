package com.xinzhe.categories.solutions.dp.subsequence;


import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/25 19:01
 * Title : 673. 最长递增子序列的个数
 * Description : 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * link : https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * Level : Medium
 */

public class Leetcode673 {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findNumberOfLIS(arr));
    }
    public static int findNumberOfLIS(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count =  new int[n];
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for(int j = i-1; j >= 0; --j) {
              if(nums[i] > nums[j]){
                  if(dp[j] +1 > dp[i]){
                      dp[i] = dp[j] +1;
                      count[i] = count[j];
                  } else if(dp[j] +1 == dp[i]){
                      count[i] += count[j];
                  }
              }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for(int i = n-1; i >= 0; --i) {
          if(dp[i] == max) {
              res += count[i];
          }
        }
        return res;
    }
}
