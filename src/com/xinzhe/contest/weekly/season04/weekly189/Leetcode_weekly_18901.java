package com.xinzhe.contest.weekly.season04.weekly189;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title : 1450. 在既定时间做作业的学生人数
 * Description : 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 * link : https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time
 * Level : Easy
 */
public class Leetcode_weekly_18901 {
    public int busyStudent(int[] s, int[] e, int time) {
        int n = s.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = s[i];
            dp[i][1] = e[i];
        }

        Arrays.sort(dp, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (time >= dp[i][0] && time <= dp[i][1]) {
                count++;
            }
        }
        return count;
    }

}
