package com.xinzhe.contest.weekly.season04.weekly197;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title : 1513. 仅含 1 的子串数
 * Description : 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。 返回所有字符都为 1 的子字符串的数目。 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * link : https://leetcode-cn.com/problems/number-of-substrings-with-only-1s
 * Level : Medium
 */
public class Leetcode_weekly_19702 {
    public static void main(String[] args) {
        Leetcode_weekly_19702 lc = new Leetcode_weekly_19702();
    }

    static final int mod = (int) (1e9 +7);
    public int numSub(String s) {
        int count = 0;
        long sum = 0;
        for (char c : s.toCharArray()) {
            if(c == '1') {
                count++;
            } else {
                if(count > 0) {
                    sum += (long)count * (count + 1) / 2;
                    count = 0;
                }
            }
        }
        sum += (long)count * (count + 1) / 2;
        return (int) (sum % mod);
    }

}
