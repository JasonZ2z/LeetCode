package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/18
 * Title :
 * Description :
 * link :
 * Level : Easy
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
                if(list.get(i).age == list.get(j).age) {
                    dp[i] = Math.max(dp[j] + list.get(i).score, dp[i]);
                }else if(list.get(i).age > list.get(j).age) {
                    if(list.get(i).score >= list.get(j).score) {
                        dp[i] = Math.max(dp[j] + list.get(i).score, dp[i]);
                    }
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
