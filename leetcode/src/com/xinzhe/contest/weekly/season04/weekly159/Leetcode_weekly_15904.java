package com.xinzhe.contest.weekly.season04.weekly159;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Xin
 * @create 2020/6/23
 * Title : 1235. 规划兼职工作
 * Description : 你打算利用空闲时间来做兼职工作赚些零花钱。这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 *          给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。注意，时间上出现重叠的 2 份工作不能同时进行。
 *          如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * link : https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling
 * Level : Hard
 * Comment 159周赛04
 */

public class Leetcode_weekly_15904 {

    public static void main(String[] args) {
        Leetcode_weekly_15904 lc = new Leetcode_weekly_15904();

    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n];
        Data[] list = new Data[n];
        for (int i = 0; i < n; ++i) {
            list[i] = new Data(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(list, Comparator.comparingInt(a -> a.end));
        for (int i = 0; i < n; ++i) {
            dp[i] = list[i].profit;
        }
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i-1], list[i].profit);
            for(int j = i-1; j >= 0; --j) {
                if(list[j].end <= list[i].start) {
                    dp[i] = Math.max(dp[i], dp[j]+list[i].profit);
                    break;
                }
            }
        }
        return dp[n-1];
    }

    class Data {
        int start;
        int end;
        int profit;
        public Data(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
