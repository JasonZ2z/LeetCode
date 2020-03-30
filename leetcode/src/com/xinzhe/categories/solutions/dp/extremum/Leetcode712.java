package com.xinzhe.categories.solutions.dp.extremum;

/**
 * @Author Xin
 * @create 2020/3/18 18:41
 * Title : 712. 两个字符串的最小ASCII删除和
 * Description : 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *          输入: s1 = "sea", s2 = "eat"
 *          输出: 231
 *          解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 *          在 "eat" 中删除 "t" 并将 116 加入总和。
 *          结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * link : https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * Level : Medium
 */
public class Leetcode712 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "at";
        System.out.println(minimumDeleteSum(s1, s2));
    }
    public static int minimumDeleteSum(String s1, String s2) {
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return 0;
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s1.charAt(i - 1);
                char d = s2.charAt(j - 1);
                if(c == d){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] =Math.min(dp[i-1][j] + c, dp[i][j-1] + d);
                }
            }
        }
        return dp[m][n];
    }
}
