package com.xinzhe.contest.weekly.season05.weekly213;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/01
 * Title : 1641. 统计字典序元音字符串的数目
 * Description : 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *              字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * link : https://leetcode-cn.com/problems/count-sorted-vowel-strings
 * Level : Medium
 */
public class Leetcode_weekly_21302 {
    public static void main(String[] args) {
        Leetcode_weekly_21302 lc = new Leetcode_weekly_21302();
        int[] arr = {3,5};
    }
    public int countVowelStrings(int n) {
        int[][] dp = new int[51][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= 50; ++i) {
            for(int j = 4; j >= 0; --j) {
                if(j == 4) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j+1];
            }
        }

        return dp[n][0];
    }
}
