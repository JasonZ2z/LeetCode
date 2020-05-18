package com.xinzhe.contest.weekly.weekly179;

/**
 * @Author Xin
 * @create 2020/5/13
 * Title : 1374. 生成每种字符都是奇数个的字符串
 * Description : 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *              返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 * link :  https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts
 * Level : Easy
 * Comment 179周赛01
 */

public class Leetcode_weekly_17901 {
    public String generateTheString(int n) {
        if ((n & 1) == 1) return "a".repeat(n);
        else return "a".repeat(n - 1) + "b";
    }
}
