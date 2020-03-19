package com.xinzhe.categories.dp.palindrome;

/**
 * @Author Xin
 * @create 2020/3/10 18:35
 * Title : 647. 回文子串
 * Description : 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * link : https://leetcode-cn.com/problems/palindromic-substrings/
 * Level : Medium
 */
public class Leetcode647 {
    public static void main(String[] args) {
        String s = "aaabbaaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings2(s));
    }
    //暴力
    public static int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length() ; j++) {
                if(helper(s, i, j)){
                    count++;
                }
            }
        }
        return count;

    }
    //dp
    public static int countSubstrings2(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0 ; j--) {
                if(s.charAt(i) == s.charAt(j)){
                    if(i-1 < j+1){
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j+1][i-1];
                    }
                } else{
                    dp[j][i] = false;
                }
                if(dp[j][i]){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean helper(String s, int start, int end) {
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}