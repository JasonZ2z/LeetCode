package com.xinzhe.contest.biweeekly.biweekly38;

/**
 * @author Xin
 * @date 2020/10/31
 * Title : 1639. 通过给定词典构造目标字符串的方案数
 * Description : 给你一个字符串列表 words和一个目标字符串target 。words 中所有字符串都长度相同。你的目标是使用给定的 words字符串列表按照下述规则构造target：
 *              从左到右依次构造target的每一个字符。
 *              为了得到target 第i个字符（下标从 0开始），当target[i] = words[j][k]时，你可以使用words列表中第 j个字符串的第 k个字符。
 *              一旦你使用了 words中第 j个字符串的第 k个字符，你不能再使用 words字符串列表中任意单词的第 x个字符（x <= k）。也就是说，所有单词下标小于等于 k的字符都不能再被使用。
 *              请你重复此过程直到得到目标字符串target。
 *              请注意， 在构造目标字符串的过程中，你可以按照上述规定使用 words列表中 同一个字符串的 多个字符。请你返回使用 words构造 target的方案数。由于答案可能会很大，请对 109 + 7取余后返回。
 * link : https://leetcode-cn.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
 * Level : Hard
 */
//todo need to review
public class Leetcode_biweekly_3804 {
    public static void main(String[] args) {
        Leetcode_biweekly_3804 lc = new Leetcode_biweekly_3804();
        String[] arr = {"acca","bbbb","caca"};
        System.out.println(lc.numWays(arr, "aba"));
    }

    static final int MOD = (int)1e9 + 7;
    Long[][] dp;
    int[][] map;
    int m, n;
    public int numWays(String[] words, String target) {
        this.m = words[0].length();
        this.n = target.length();
        this.map = new int[m][26];
        this.dp = new Long[m+1][n+1];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                map[i][word.charAt(i) - 'a']++;
            }
        }
        return (int) solve(m, n, target);
    }

    private long solve(int i, int j, String target) {
        if (j == 0) return 1;
        if (i < j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        long ans = solve(i-1, j, target);
        ans += map[i-1][target.charAt(j-1) - 'a'] * solve(i-1, j-1, target);
        return dp[i][j] = ans % MOD;
    }
}
