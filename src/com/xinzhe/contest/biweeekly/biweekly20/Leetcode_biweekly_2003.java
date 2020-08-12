package com.xinzhe.contest.biweeekly.biweekly20;

/**
 * @author Xin
 * @date 2020/5/18
 * Title : 1358. 包含所有三种字符的子字符串数目
 * Description : 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * link : https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters/
 * Level : Medium
 * Comment 20双周赛03
 */

public class Leetcode_biweekly_2003 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aabcabc"));
    }

    //todo 双指针

    //前缀和 + 二分
    public static int numberOfSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < arr.length; i++) {
            dp[i + 1][0] = arr[i] == 'a' ? dp[i][0] + 1 : dp[i][0];
            dp[i + 1][1] = arr[i] == 'b' ? dp[i][1] + 1 : dp[i][1];
            dp[i + 1][2] = arr[i] == 'c' ? dp[i][2] + 1 : dp[i][2];
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int left = i + 1, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (ok(mid, dp, i)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (ok(left, dp, i)) count += n - left + 1;
        }
        return count;
    }

    private static boolean ok(int mid, int[][] dp, int i) {

        return dp[mid][0] - dp[i][0] > 0 && dp[mid][1] - dp[i][1] > 0 && dp[mid][2] - dp[i][2] > 0;
    }
}
