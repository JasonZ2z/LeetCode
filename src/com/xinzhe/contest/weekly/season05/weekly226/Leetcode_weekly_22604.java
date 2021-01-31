package com.xinzhe.contest.weekly.season05.weekly226;

/**
 * @author Xin
 * @date 2021/01/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22604 {
    public static void main(String[] args) {
        Leetcode_weekly_22604 lc = new Leetcode_weekly_22604();
    }
    public int palindromePartition(String s) {
        int[][] pali= new int[s.length() + 1][s.length() + 1];
        for(int i = s.length(); i >= 1; i--)
        {
            for(int j = i; j <= s.length(); j++)
            {
                if(j - i >= 2)
                    pali[i][j] = pali[i + 1][j - 1];
                if(s.charAt(i - 1) != s.charAt(j - 1))
                    pali[i][j]++;
            }
        }

        int[][] dp = new int[4][s.length() + 1];
        for(int i = 1; i <= 3; i++)
        {
            for(int j = i; j <= s.length(); j++)
            {
                if(i == 1)
                    dp[i][j] = pali[i][j];
                else
                {
                    dp[i][j] = dp[i - 1][i - 1] + pali[i][j];
                    for(int x = i; x < j; x++)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + pali[x + 1][j]);
                }
            }
        }
        return dp[3][s.length()];
    }
}
