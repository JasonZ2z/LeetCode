package com.xinzhe.contest.weekly.weekly173;

/**
 * @Author Xin
 * @create 2020/5/21
 * Title : 1332. 删除回文子序列
 * Description :
 * link : https://leetcode-cn.com/problems/remove-palindromic-subsequences
 * Level : Hard
 * Comment 173周赛04
 */

public class Leetcode_weekly_17304 {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) return 0;
        if (helper(s)) return 1;
        return 2;
    }

    public boolean helper(String s) {
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
