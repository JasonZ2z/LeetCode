package com.xinzhe.contest.weekly.season04.weekly199;

/**
 * @author Xin
 * @date 2020/7/25
 * Title : 1531. 压缩字符串 II
 * Description : 行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。
 *              例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 *              给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 * link : https://leetcode-cn.com/problems/string-compression-ii
 * Level : Hard
 */

//todo too hard to solve
public class Leetcode_weekly_19904 {
    public static void main(String[] args) {
        Leetcode_weekly_19904 lc = new Leetcode_weekly_19904();
    }

    Integer[][][][] dp;
    String s;
    int k;
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        this.s = s;
        this.k = k;
        this.dp = new Integer[n + 1][26][n + 1][k + 1];
        return dfs(0, s.charAt(0), 0 );
    }

    private int dfs(int cur, char c, int num){
        int n = s.length();
        if(cur >= n){
            return num <= 1 ? num: 1 + (num >= 10 ? 2: 1);
        }
        if(dp[cur][c - 'a'][num][k] != null){
            return dp[cur][c - 'a'][num][k];
        }
        if(s.charAt(cur) != c){
            dp[cur][c - 'a'][num][k] = (num <= 1 ? num: 1 + (num >= 10 ? 2: 1)) + dfs(cur + 1, s.charAt(cur), 1);
        } else {
            dp[cur][c - 'a'][num][k] = dfs( cur + 1, c, num + 1);
        }
        if(k > 0){
            dp[cur][c - 'a'][num][k] = Math.min(dp[cur][c - 'a'][num][k], dfs(cur + 1, c, num));
        }
        return dp[cur][c - 'a'][num][k];
    }
}
