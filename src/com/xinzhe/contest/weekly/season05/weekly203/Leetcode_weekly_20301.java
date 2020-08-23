package com.xinzhe.contest.weekly.season05.weekly203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_20301 {
    public static void main(String[] args) {
        Leetcode_weekly_20301 lc = new Leetcode_weekly_20301();
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] dp = new int[n];

        for (int i = 0; i < rounds.length-1; i++) {
            int start = rounds[i];
            int end = rounds[i+1];
            if(end > start) {
                for (int j = start; j < end; ++j) {
                    dp[(j-1)%n]++;
                }
            } else {
                for (int j = start; j < n + end; ++j) {
                    dp[(j-1)%n]++;
                }
            }
        }
        dp[rounds[rounds.length-1]-1]++;
        int max = Arrays.stream(dp).max().orElse(0);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] == max)res.add(i+1);
        }
        return res;
    }
}
