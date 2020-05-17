package com.xinzhe.contest.weekly.weekly178;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/5/15
 * Title : 1366. 通过投票对团队排名
 * Description : 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
 * 排名规则如下：
 * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
 * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
 * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
 * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
 * link : https://leetcode-cn.com/problems/rank-teams-by-votes
 * Level : Medium
 * Comment 178周赛02
 */

public class Leecode_weekly_17802 {
    public static void main(String[] args) {
        Leecode_weekly_17802 lc = new Leecode_weekly_17802();
        String[] v = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
        System.out.println(lc.rankTeams(v));
        System.out.println(lc.rankTeams2(v));
    }

    public String rankTeams(String[] votes) {
        int m = votes.length;
        if (m == 1) return votes[0];
        int n = votes[0].length();
        int[][] dp = new int[n][26];

        for (String vote : votes) {
            char[] arr = vote.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                dp[i][arr[i] - 'A']++;
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (char c : votes[0].toCharArray()) {
            set.add(c - 'A');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int index = getChar(dp, 0, set);
            for (int j = 0; j < n; ++j) {
                dp[j][index] = 0;
            }
            set.remove(index);
            sb.append((char) (index + 'A'));
        }
        return sb.toString();
    }

    private int getChar(int[][] dp, int level, TreeSet<Integer> set) {
        if (set.size() == 1 || level == dp.length) return set.first();
        int max = set.first();
        for (int i : set) {
            if (dp[level][i] > dp[level][max]) {
                max = i;
            }
        }
        TreeSet<Integer> newSet = new TreeSet<>();
        for (int i : set) {
            if (dp[level][i] == dp[level][max]) {
                newSet.add(i);
            }
        }
        return getChar(dp, level + 1, newSet);
    }


    // stream API 排序
    public String rankTeams2(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
            char[] arr = vote.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                int[] rank = map.getOrDefault(arr[i], new int[26]);
                rank[i]++;
                map.put(arr[i], rank);
            }
        }
        return map.entrySet().stream().sorted((a, b) -> {
            for (int i = 0; i < 26; ++i) {
                if (a.getValue()[i] != b.getValue()[i]) {
                    return b.getValue()[i] - a.getValue()[i];
                }
            }
            return a.getKey() - b.getKey();
        }).map(a -> String.valueOf(a.getKey())).collect(Collectors.joining());
    }
}
