package com.xinzhe.contest.weekly.season04.weekly187;

/**
 * @Author Xin
 * @create 2020/5/3
 * Title :
 * Description :
 * link :
 * Level :
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