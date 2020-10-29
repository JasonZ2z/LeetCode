package com.xinzhe.categories.solutions.dp.exist;

/**
 * @author Xin
 * @date 2020/10/28
 * Title : 10. 正则表达式匹配
 * Description : 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *              '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素, 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * link : https://leetcode-cn.com/problems/regular-expression-matching
 * Level : Hard
 */

//todo need to review
public class Leetcode010 {
    public static void main(String[] args) {
    }
    //ab == .*
    //ab == a*;
    //a == a*
    //"" == .*;
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        if(m == 0 && n == 0) return true;

        boolean [][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if(i > 1 && p.charAt(i-1) == '*' && dp[0][i-2]) dp[0][i] = true;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') dp[i][j] = dp[i-1][j-1];
                if(j > 1 && p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if(dp[i][j]) continue;
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                        if(dp[i-1][j]) dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
