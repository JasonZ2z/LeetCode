package com.xinzhe.categories.backtrack;


import java.util.ArrayList;

/**
 * @Author Xin
 * @create 2020/3/5 18:55
 * Title : 132. 分割回文串 II
 * Description : 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的最少分割次数。
 * link : https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * Level : Hard
 */

//todo
public class Leetcode132 {

    public static void main(String[] args) {
        String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
        System.out.println(minCut(s));
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
        while (start < end){
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
