package com.xinzhe.contest.weekly.season05.weekly228;

/**
 * @author Xin
 * @date 2021/02/07
 * Title : 1759. 统计同构子字符串的数目
 * Description : 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 *              同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。子字符串 是字符串中的一个连续字符序列。
 * link : https://leetcode-cn.com/problems/count-number-of-homogenous-substrings
 * Level : Medium
 */
public class Leetcode_weekly_22802 {
    public static void main(String[] args) {
        Leetcode_weekly_22802 lc = new Leetcode_weekly_22802();
    }
    public int countHomogenous(String s) {
        int n = s.length();
        int mod = (int)1e9 + 7;
        char c = s.charAt(0);
        long count = 1;
        long res = 0;
        for (int i = 1; i < n; ++i) {
            if(s.charAt(i) != c) {
                res += count * (count + 1) / 2;
                count = 1L;
                c = s.charAt(i);
            } else {
                count++;
            }
        }
        res += count * (count + 1) / 2;
        return (int) (res % mod);
    }
}
