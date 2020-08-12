package com.xinzhe.contest.biweeekly.biweekly18;

/**
 * @author Xin
 * @date 2020/5/22
 * Title : 1328. 破坏回文串
 * Description : 给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 * link : https://leetcode-cn.com/problems/break-a-palindrome
 * Level : Medium
 * Comment 18双周赛02
 */

public class Leetcode_biweekly_1802 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n <= 1) return "";

        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }
}
