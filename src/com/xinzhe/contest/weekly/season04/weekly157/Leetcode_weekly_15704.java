package com.xinzhe.contest.weekly.season04.weekly157;

/**
 * @author Xin
 * @date 2020/7/16
 * Title : 1220. 统计元音字母序列的数目
 * Description : 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 *          每个元音 'a' 后面都只能跟着 'e'
 *          每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 *          每个元音 'i' 后面 不能 再跟着另一个 'i'
 *          每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 *          每个元音 'u' 后面只能跟着 'a'
 *          由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * link : https://leetcode-cn.com/problems/count-vowels-permutation
 * Level : Hard
 * Comment 157周赛04
 */

public class Leetcode_weekly_15704 {

    public static void main(String[] args) {
        Leetcode_weekly_15704 lc = new Leetcode_weekly_15704();
    }
    static final int MOD = (int)1e9+7;
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][5];
        for (int i = 0; i < 5; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD;
            dp[i][3] = (dp[i-1][2]) % MOD;
            dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % MOD;
        }
        long count = 0;
        for (int i = 0; i < 5; ++i) {
            count = (count + dp[n][i]) % MOD;
        }
        return (int)count;
    }


}
