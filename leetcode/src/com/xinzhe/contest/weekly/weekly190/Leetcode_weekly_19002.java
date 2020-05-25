package com.xinzhe.contest.weekly.weekly190;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/24
 * Title : 1456. 定长子串中元音的最大数目
 * Description : 给你字符串 s 和整数 k 。请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。 英文中的 元音字母 为（a, e, i, o, u）。
 * link : https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 * Level : Medium
 * Comment 190周赛02
 */
public class Leetcode_weekly_19002 {
    public static void main(String[] args) {
        System.out.println(maxVowels("tryhard", 4));
    }

    public static int maxVowels(String s, int k) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        char[] arr = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (list.contains(arr[i])) {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = dp[i];
            }
        }
        int max = 0;
        for (int i = k; i <= n; ++i) {
            max = Math.max(dp[i] - dp[i - k], max);
            if (max == k) {
                break;
            }
        }
        return max;
    }
}
