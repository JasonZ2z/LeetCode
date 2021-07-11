package com.xinzhe.contest.weekly.season05.weekly249;

/**
 * @author Xin
 * @date 2021/07/11
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24902 {
    public static void main(String[] args) {
        Leetcode_weekly_24902 lc = new Leetcode_weekly_24902();

    }

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n + n];

        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

}
