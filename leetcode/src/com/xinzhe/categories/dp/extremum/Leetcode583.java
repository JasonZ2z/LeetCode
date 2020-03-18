package com.xinzhe.categories.dp.extremum;

/**
 * @Author Xin
 * @create 2020/3/18 18:51
 * Title : 583. 两个字符串的删除操作
 * Description : 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *          输入: s1 = "sea", s2 = "eat"
 *          输出: 2
 * link : https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * Level : Medium
 */
public class Leetcode583 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "at";
        System.out.println(minimumDeleteSum(s1, s2));
    }
    public static int minimumDeleteSum(String s1, String s2) {
        if(s1 == null ||  s2 == null ) return 0;
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if(c1 == c2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] ,dp[i][j-1]) +1;
                }
            }
        }
        return dp[m][n];
    }
}
