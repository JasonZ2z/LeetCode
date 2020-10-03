package com.xinzhe.contest.weekly.season05.weekly203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1560. 圆形赛道上经过次数最多的扇区
 * Description : 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。
 *              其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 *              请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。 注意，赛道按扇区编号升序逆时针形成一个圆
 * link :  https://leetcode-cn.com/problems/most-visited-sector-in-a-circular-track
 * Level : Easy
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
