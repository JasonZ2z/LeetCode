package com.xinzhe.contest.biweeekly.biweekly39;

/**
 * @author Xin
 * @date 2020/11/14
 * Title :
 * Description :
 * link :
 * Level : Easy
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
