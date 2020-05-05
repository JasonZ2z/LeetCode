package com.xinzhe.order.day07;

/**
 * @Author Xin
 * @create 2020/5/5
 * Title : 1397. 找到所有好字符串
 * Description : 给你两个长度为 n 的字符串 s1 和 s2 ，以及一个字符串 evil 。请你返回 好字符串 的数目。
 * 好字符串 的定义为：它的长度为 n ，字典序大于等于 s1 ，字典序小于等于 s2 ，且不包含 evil 为子字符串。
 * 由于答案可能很大，请你返回答案对 10^9 + 7 取余的结果。
 * link : https://leetcode-cn.com/problems/find-all-good-strings
 * Level : Hard
 */
public class Leetcode_weekly_18204 {
    //todo
    //数位DP + KMP
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if(s1.compareTo(s2) > 0) {
            return 0;
        }
        return 0;
    }
}
