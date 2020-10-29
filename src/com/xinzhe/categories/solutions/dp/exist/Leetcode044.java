package com.xinzhe.categories.solutions.dp.exist;

/**
 * @author Xin
 * @date 2020/10/29
 * Title : 44. 通配符匹配
 * Description : 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *              '?' 可以匹配任何单个字符。'*' 可以匹配任意字符串（包括空字符串）。 两个字符串完全匹配才算匹配成功。
 * link : https://leetcode-cn.com/problems/wildcard-matching
 * Level : Hard
 */

//todo need to review
public class Leetcode044 {
    public static void main(String[] args) {
    }
    public boolean isMatch(String s, String p) {
        if(s == null ||  p == null) return false;
        int m = s.length(), n = p.length();
        if(n == 0) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) dp[i][j] = dp[i-1][j-1];
                if(p.charAt(j-1) == '*')  dp[i][j] |= dp[i-1][j] | dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
