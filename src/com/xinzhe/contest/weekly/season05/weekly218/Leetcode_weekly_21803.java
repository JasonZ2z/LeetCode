package com.xinzhe.contest.weekly.season05.weekly218;

/**
 * @author Xin
 * @date 2020/12/06
 * Title : 1680. 连接连续二进制数字
 * Description : 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * link : https://leetcode-cn.com/problems/concatenation-of-consecutive-binary-numbers/
 * Level : Medium
 */
public class Leetcode_weekly_21803 {
    public static void main(String[] args) {
        Leetcode_weekly_21803 lc = new Leetcode_weekly_21803();
        int[] arr = {3,5};
        System.out.println(lc.concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {
        long x = 1;
        int mod = (int)1e9+7;
        for (int i = 2; i <= n; ++i) {
            x <<= Integer.toBinaryString(i).length();
            x %= mod;
            x += i;
        }
        x %= mod;

        return (int) x;
    }
}
