package com.xinzhe.contest.weekly.season04.weekly197;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title :  1512. 好数对的数目
 * Description : 给你一个整数数组 nums 。 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。 返回好数对的数目。
 * link : https://leetcode-cn.com/problems/number-of-good-pairs
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
