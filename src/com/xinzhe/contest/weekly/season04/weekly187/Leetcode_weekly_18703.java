package com.xinzhe.contest.weekly.season04.weekly187;

/**
 * @author Xin
 * @date 2020/5/3
 * Title : 1438. 绝对差不超过限制的最长连续子数组
 * Description : 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *              如果不存在满足条件的子数组，则返回 0 。
 * link : https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * Level : Medium
 */
public class Leetcode_weekly_18703 {
    public static void main(String[] args) {
        int[] num = {4,8,5,1,7,9};
        System.out.println(longestSubarray(num, 6));
    }
    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int res = 1;
        int[] dp = new int[n];
        int[] max = new int[n];
        int[] min = new int[n];

        dp[0] = 1;
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if(nums[i] <= max[i-1] && nums[i] >= min[i-1]) {
                dp[i] = dp[i-1] + 1;
                max[i] = max[i-1];
                min[i] = min[i-1];
            } else if(Math.abs(nums[i] - nums[i-1]) <= limit) {
                if( Math.abs(nums[i] - min[i-1]) <= limit && Math.abs(nums[i] - max[i-1]) <= limit){
                    dp[i] = dp[i-1] + 1;
                    max[i] = Math.max(max[i-1], nums[i]);
                    min[i] = Math.min(min[i-1], nums[i]);
                } else {
                    int max_tmp = nums[i];
                    int min_tmp = nums[i];
                    int count = 1;
                    for(int j = i-1; j >= 0; --j) {
                        if(Math.abs(nums[i] - nums[j]) <= limit) {
                            count++;
                            max_tmp = Math.max(max_tmp, nums[j]);
                            min_tmp = Math.min(min_tmp, nums[j]);
                        } else {
                            break;
                        }
                    }
                    dp[i] = count;
                    max[i] = max_tmp;
                    min[i] = min_tmp;
                }

            } else {
                dp[i] = 1;
                max[i] = nums[i];
                min[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
