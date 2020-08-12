package com.xinzhe.contest.weekly.season04.weekly192;

/**
 * @author Xin
 * @date 2020/6/7
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 192周赛01
 */
public class Leetcode_weekly_19201 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];
        for (int i = 0; i < 2 * n; i += 2) {
            res[i] = nums[i / 2];
            res[i + 1] = nums[i / 2 + n];
        }
        return res;
    }

}
