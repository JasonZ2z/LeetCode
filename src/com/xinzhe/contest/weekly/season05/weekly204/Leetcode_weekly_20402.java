package com.xinzhe.contest.weekly.season05.weekly204;

/**
 * @author Xin
 * @date 2020/8/30
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20402 {
    public static void main(String[] args) {
        Leetcode_weekly_20402 lc = new Leetcode_weekly_20402();
        //int[] arr = {-1,-2,-3,0,1};
       // int[] arr = {-1,2 };
        int[] arr = {1,-2,-3,4};

        System.out.println(lc.getMaxLen(arr));
    }
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int max = 0;

        if(n == 1){
            if(nums[0] <= 0) return 0;
            else return 1;
        }

        int[][] dp = new int[n][2];
        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            if(nums[i] > 0) {
                dp[i][i] = 1;
                flag = true;
            }
            else if(nums[i] < 0) dp[i][i] = -1;
        }
        if(flag) max = 1;

        for (int i = 0; i < n; ++i) {
            if(nums[i] == 0) continue;
            for (int j = i-1; j >=0; --j) {
                if(nums[j] > 0) {
                    dp[j][i] = dp[j + 1][i] > 0 ? 1 : -1;
                } else if(nums[j] == 0) {
                    break;
                } else {
                    dp[j][i] = dp[j + 1][i] < 0 ? 1 : -1;
                }
                if(dp[j][i] > 0) {
                    max = Math.max(max, i -j+ 1);
                }
            }
        }
        return max;

    }


}
