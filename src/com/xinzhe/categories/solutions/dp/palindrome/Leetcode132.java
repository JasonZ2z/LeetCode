package com.xinzhe.categories.solutions.dp.palindrome;


import java.util.ArrayList;

/**
 * @author Xin
 * @date 2020/3/5 18:55
 * Title : 132. 分割回文串 II
 * Description : 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的最少分割次数。
 * link : https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * Level : Hard
 */

public class Leetcode132 {

    public static void main(String[] args) {
        String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
        //String s = "aab";
        System.out.println(minCut2(s));
        System.out.println(minCut3(s));

    }
    public static int minCut2(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] isPalindrome = new boolean[n][n];
        int p,q;
        for (int i = 0; i < n; i++) {
            p = i; q = i;
            while (p >=0 && q < n && arr[p] == arr[q]){
                isPalindrome[p][q] = true;
                --p;
                ++q;
            }
            p = i; q= i+1;
            while (p >=0 && q < n && arr[p] == arr[q]){
                isPalindrome[p][q] = true;
                --p;
                ++q;
            }
        }
        int[] dp = new int[n+1];
        dp[0] =0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; ++j) {
                if(isPalindrome[j][i-1]){
                    dp[i] = Math.min(dp[i], dp[j] +1);
                }
            }
        }
        return dp[n]-1;
    }

    public static int minCut3(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();

        int[] dp = new int[n+1];
        dp[0] =0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; ++j) {
                if(isPalindrome(s, j, i-1)){
                    dp[i] = Math.min(dp[i], dp[j] +1);
                }
            }
        }
        return dp[n]-1;
    }


    //dfs 超时
    static int min = Integer.MAX_VALUE;
    public static int minCut(String s) {
        if(isPalindrome(s, 0, s.length()-1)){
            return 0;
        }else {
            dfs(s, new ArrayList<>(), 0);
            return min;
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;

    }

    private static void dfs(String s, ArrayList<String> track, int start) {
        if(start == s.length()){
            min = Math.min(min, track.size()-1);
            return;
        }
        if(start > s.length() || track.size() >= min) return;

        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)){
                track.add(s.substring(start,i+1));
                dfs(s, track, i+1);
                track.remove(track.size()-1);
            }
        }
    }
}
