package com.xinzhe.contest.weekly.season05.weekly226;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/01/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22601 {
    public static void main(String[] args) {
        Leetcode_weekly_22601 lc = new Leetcode_weekly_22601();
    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] dp = new int[80];
        for (int i = lowLimit; i <= highLimit ; ++i) {
            int x = get(i);
            dp[x]++;
        }
        return Arrays.stream(dp).max().orElse(1);
    }

    private int get(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i /= 10;
        }
        return res;
    }
}
