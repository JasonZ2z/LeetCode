package com.xinzhe.contest.weekly.season04.weekly199;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_19904 {
    public static void main(String[] args) {
        Leetcode_weekly_19904 lc = new Leetcode_weekly_19904();
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        Integer[][][][] dp = new Integer[n + 1][26][n + 1][k + 1];
        return dfs(dp, s, 0, s.charAt(0), 0, k);
    }

    private int dfs(Integer[][][][] dp, String s, int cur, char c, int num, int k){
        int n = s.length();
        if(cur >= n){
            return num <= 1 ? num: 1 + (num >= 10 ? 2: 1);
        }
        if(dp[cur][c - 'a'][num][k] != null){
            return dp[cur][c - 'a'][num][k];
        }
        if(s.charAt(cur) != c){
            dp[cur][c - 'a'][num][k] = (num <= 1 ? num: 1 + (num >= 10 ? 2: 1)) + dfs(dp, s, cur + 1, s.charAt(cur), 1, k);
        } else {
            dp[cur][c - 'a'][num][k] = dfs(dp, s, cur + 1, c, num + 1, k);
        }
        if(k > 0){
            dp[cur][c - 'a'][num][k] = Math.min(dp[cur][c - 'a'][num][k], dfs(dp, s, cur + 1, c, num, k - 1));
        }
        return dp[cur][c - 'a'][num][k];
    }
}
