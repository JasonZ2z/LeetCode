package com.xinzhe.contest.weekly.season05.weekly219;

/**
 * @author Xin
 * @date 2020/12/13
 * Title : 1689. 十-二进制数的最少数目
 * Description : 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 *               给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 * link : https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 * Level : Medium
 */
public class Leetcode_weekly_21902 {
    public static void main(String[] args) {
        Leetcode_weekly_21902 lc = new Leetcode_weekly_21902();
        int[] arr = {3,5};
    }
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            int x = c - '0';
            max = Math.max(x , max);
        }
        return max;
    }
}
