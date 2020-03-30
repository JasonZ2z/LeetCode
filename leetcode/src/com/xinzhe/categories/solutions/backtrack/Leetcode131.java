package com.xinzhe.categories.solutions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/5 18:55
 * Title : 131. 分割回文串
 * Description : 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *      示例:
 *      输入: "aab"
 *  输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * link : https://leetcode-cn.com/problems/palindrome-partitioning
 * Level : Medium
 */
public class Leetcode131 {
    public static void main(String[] args) {
        String s = "seeslaveidemonstrateyetartsnomedievalsees";
        System.out.println(partition(s));
    }

    public static boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;

    }
    static List<List<String>> result = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(String s, ArrayList<String> track, int start) {
        if(start == s.length()){
            result.add(new ArrayList<>(track));
            return;
        }
        if(start > s.length()) return;

        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)){
                track.add(s.substring(start,i+1));
                dfs(s, track, i+1);
                track.remove(track.size()-1);
            }
        }
    }
}
