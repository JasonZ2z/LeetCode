package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/18
 * Title : 1626. 无矛盾的最佳球队
 * Description : 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *              然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *              给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 * link : https://leetcode-cn.com/problems/best-team-with-no-conflicts
 * Level : Medium
 */
public class Leetcode_weekly_21103 {
    public static void main(String[] args) {
        Leetcode_weekly_21103 lc = new Leetcode_weekly_21103();
        int[] arr = {3,5};
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new Node(ages[i], scores[i]));
        }
        list.sort((a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        dp[0] = list.get(0).score;

        int max = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = list.get(i).score;
            for(int j = i-1; j >= 0; --j) {
                if(list.get(i).score >= list.get(j).score) {
                    dp[i] = Math.max(dp[j] + list.get(i).score, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    class Node {
        int age;
        int score;

        public Node(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }
}
