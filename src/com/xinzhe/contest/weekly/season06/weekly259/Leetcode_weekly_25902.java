package com.xinzhe.contest.weekly.season06.weekly259;

/**
 * @author Xin
 * @date 2021/09/19
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25902 {
    public static void main(String[] args) {
        Leetcode_weekly_25902 lc = new Leetcode_weekly_25902();

    }
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int count = 0;
        boolean flag = true;
        for (int i = 1; i < n - 1; ++i) {
            if(nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                count++;
            } else {
                flag = false;
            }
        }
        if(flag) return 2 * n - 4;
        return count;
    }
}
