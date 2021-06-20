package com.xinzhe.contest.biweeekly.s1.biweekly39;

/**
 * @author Xin
 * @date 2020/11/14
 * Title : 1653. 使字符串平衡的最少删除次数
 * Description : 给你一个字符串s，它仅包含字符'a' 和'b' 。你可以删除s中任意数目的字符，使得s 平衡。
 *              我们称s平衡的当不存在下标对(i,j)满足i < j 且s[i] = 'b'同时s[j]= 'a'。请你返回使 s平衡的 最少删除次数。
 * link : https://leetcode-cn.com/problems/minimum-deletions-to-make-string-balanced
 * Level : Medium
 */
public class Leetcode_biweekly_3902 {
    public static void main(String[] args) {
        Leetcode_biweekly_3902 lc = new Leetcode_biweekly_3902();
        int[] arr = {1,1,2,2,2,3};
        System.out.println(lc.minimumDeletions("bbaaaaabb"));
    }
    public int minimumDeletions(String s) {
        int n = s.length();
        if(n == 1) return 0;
        int[][] dp = new int[n][2];

        if(s.charAt(0) == 'a') {
            dp[0][0] = 1;
            dp[0][1] = 0;
        } else {
            dp[0][0] = 0;
            dp[0][1] = 1;
        }
        int max = 0;
        for (int i = 1; i < n; ++i) {
            if(s.charAt(i) == 'a') {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = Math.max(dp[i][0], dp[i-1][1]);
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]) + 1;
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return n - max;
    }
}
