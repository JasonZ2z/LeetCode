package com.xinzhe.contest.weekly.season04.weekly181;

/**
 * @Author Xin
 * @create 2020/5/5
 * Title : 1392. 最长快乐前缀
 * Description : 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
 *              给你一个字符串 s，请你返回它的 最长快乐前缀。
 *              如果不存在满足题意的前缀，则返回一个空字符串。
 * link : https://leetcode-cn.com/problems/longest-happy-prefix
 * Level : Hard
 * Comment : 181周赛04
 */
//todo need to review
public class Leetcode_weekly_18104 {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(longestPrefix(s));
    }
    public static String longestPrefix(String s) {
        int n = s.length();
        int[] next = getNext(s);

        int len = next[n];
        return s.substring(0,len);
    }

    private static int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n+1];
        next[0] = -1;
        int i=0, j=-1;
        while (i < n) {
            if(j==-1 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
                //System.out.println(Arrays.toString(next));
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
