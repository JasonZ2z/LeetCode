package com.xinzhe.categories.dp.subsequence;

/**
 * @Author Xin
 * @create 2020/3/20 19:13
 * Title : 97. 交错字符串
 * Description : 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * link : https://leetcode-cn.com/problems/interleaving-string/
 * Level : Hard
 */
public class Leetcode097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (l != n + m) { return false; }
        //dp[i][j] 为s3前i+j个字符是否由s1前i个字符 A[0..i-1]和s2前j个字符B[0..j-1]交错形成。
        boolean[][] dp = new boolean[m+1][n+1];

        //init
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i > 0 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
                if(j > 0 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}
