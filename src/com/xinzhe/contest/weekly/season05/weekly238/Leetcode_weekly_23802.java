package com.xinzhe.contest.weekly.season05.weekly238;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/04/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
//todo need to review
public class Leetcode_weekly_23802 {
    public static void main(String[] args) {
        Leetcode_weekly_23802 lc = new Leetcode_weekly_23802();

    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long count = 0, cur = 1;
        int max = 1;
        for (int i = 1, j = 0; i < nums.length; ++i) {
            count += cur * (nums[i] - nums[i-1]);
            cur++;
            while (count > k) {
                count -= nums[i] - nums[j++];
                cur--;
            }
            max = Math.max(max, i - j +1);
        }
        return max;
    }
}
