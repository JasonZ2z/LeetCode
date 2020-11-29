package com.xinzhe.contest.weekly.season05.weekly217;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/29
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21701 {
    public static void main(String[] args) {
        Leetcode_weekly_21701 lc = new Leetcode_weekly_21701();
        int[] arr = {3,5};
    }
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(Arrays.stream(account).sum(), max);
        }
        return max;
    }
}
