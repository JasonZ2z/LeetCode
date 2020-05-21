package com.xinzhe.contest.weekly.weekly173;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/21
 * Title : 1335. 工作计划的最低难度
 * Description : 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
 *              你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
 *              给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
 *              返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 
 * link : https://leetcode-cn.com/problems/minimum-difficulty-of-a-job-schedule
 * Level : Hard
 * Comment 173周赛04
 */

public class Leetcode_weekly_17304 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        if (n == d) return Arrays.stream(jobDifficulty).sum();

        int[][] dp = new int[n][d];
        int max = 0;
        for (int i = 0; i < d; ++i) {
            for (int j = 0; j < n; ++j) {
                //todo
            }
        }
        return max;
    }
}
