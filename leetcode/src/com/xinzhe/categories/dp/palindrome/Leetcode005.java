package com.xinzhe.categories.dp.palindrome;

/**
 * @Author Xin
 * @create 2020/3/10 18:32
 * Title : 5. 最长回文子串
 * Description : 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * link : https://leetcode-cn.com/problems/longest-palindromic-substring/
 * Level : Medium
 */
//todo need to review
public class Leetcode005 {
    public String longestPalindrome(String s) {

        //1. dp[i][j] 表示子串 s[i, j] 是否为回文子串。
        //2. 状态转移方程: dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
        //2.1 if i + 1 < j - 1 && s[i] == s[j] --> dp[i][j] = dp[i + 1][j - 1]
        //2.2 else s[i] == s[j] && i + 1 >= j - 1 --> true [i + 1, j - 1] 不构成区间，即长度严格小于 3, 只要收尾相等即true
        //2,3 else false;
        //3. 对角线先初始化为 1，即 dp[i][i] = 1 。
        if(s == null || s.length() <= 1) return s;
        int n = s.length();
        int max = 1;
        int left=0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //dp[i][j] = s.charAt(i) == s.charAt(j) && (i-1 < j+1 || dp[j+1][i-1]);
                if(s.charAt(i) == s.charAt(j)){
                    if(i-1 > j+1){
                        dp[j][i] = dp[j+1][i-1];
                    } else {
                        dp[j][i] = true;
                    }

                } else {
                    dp[j][i] = false;
                }
                if(dp[j][i]){
                    if(max < i-j+1){
                        max = i-j+1;
                        left = j;
                    }

                }
            }
        }
        return s.substring(left, left+max);
    }
}
