package com.xinzhe.contest.biweeekly.s1.biweekly32;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/8
 * Title : 1542. 找出最长的超赞子字符串
 * Description : 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。「超赞子字符串」需满足满足下述两个条件：
 *              该字符串是 s 的一个非空子字符串进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 * link : https://leetcode-cn.com/problems/find-longest-awesome-substring
 * Level : Hard
 * tag :状态压缩
 */

//todo need to review
public class Leetcode_biweekly_3204 {
    public static void main(String[] args) {
        Leetcode_biweekly_3204 lc = new Leetcode_biweekly_3204();
        System.out.println(lc.longestAwesome("3242415"));
    }

    public int longestAwesome(String s) {
        int n = s.length();
        int[] dp = new int[1<<10];
        Arrays.fill(dp, n);
        int res = 0, mask = 0;
        dp[0] = -1;
        for (int i = 0; i < n; ++i) {
            mask ^= 1<<(s.charAt(i) - '0');
            res = Math.max(res, i - dp[mask]);
            for (int j = 0; j < 10; ++j) {
                res = Math.max(res, i - dp[mask ^ (1<<j)]);
            }
            dp[mask] = Math.min(dp[mask], i);
        }
        return res;
    }


}
