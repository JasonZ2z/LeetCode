package com.xinzhe.contest.weekly.season03.weekly141;

/**
 * @author Xin
 * @date 2020/8/20
 * Title : 1092. 最短公共超序列
 * Description : 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 * （            如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 * link : https://leetcode-cn.com/problems/shortest-common-supersequence
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_14104 {
    public static void main(String[] args) {
        Leetcode_weekly_14104 lc = new Leetcode_weekly_14104();
        System.out.println(lc.shortestCommonSupersequence("abc", "bd"));
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if(n1 < n2) return shortestCommonSupersequence(s2, s1);

        int[][] dp = new int[n1+1][n2+1];
        int max = 0;
        int p = 0, q = 0;
        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                if(dp[i][j] > max) {
                    max = dp[i][j];
                    p = i;
                    q = j;
                }
            }
        }
        String end = s1.substring(p) + s2.substring(q);
        StringBuilder sb = new StringBuilder();
        while(p > 0 || q > 0) {
            if(p <= 0) {
                sb.append(s2.charAt(q-1));
                q--;
                continue;
            } else if( q <= 0) {
                sb.append(s1.charAt(p-1));
                p--;
                continue;
            }
            int val = dp[p][q];
            if(val == dp[p-1][q]){
                sb.append(s1.charAt(p-1));
                p--;
            } else if(val == dp[p][q-1]) {
                sb.append(s2.charAt(q-1));
                q--;
            } else {
                sb.append(s1.charAt(p-1));
                p--;
                q--;
            }
        }
        return sb.reverse().toString() + end;
    }
}
