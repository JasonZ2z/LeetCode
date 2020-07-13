package com.xinzhe.contest.weekly.season04.weekly197;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_19701 {
    public static void main(String[] args) {
        Leetcode_weekly_19701 lc = new Leetcode_weekly_19701();
    }
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n-1; ++i) {
            for (int j = i+1; j < n; ++j) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
