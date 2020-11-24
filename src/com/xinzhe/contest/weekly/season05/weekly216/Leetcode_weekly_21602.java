package com.xinzhe.contest.weekly.season05.weekly216;

/**
 * @author Xin
 * @date 2020/11/22
 * Title : 1663. 具有给定数值的最小字符串
 * Description : 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 *              字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 *              给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 *              注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 *                  x 是 y 的一个前缀；
 *                  如果 i 是 x[i] != y[i] 的第一个位置，且 x[i]在字母表中的位置比 y[i] 靠前。
 * link : https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value
 * Level : Medium
 */
public class Leetcode_weekly_21602 {
    public static void main(String[] args) {
        Leetcode_weekly_21602 lc = new Leetcode_weekly_21602();
        int[] arr = {3,5};
        System.out.println(lc.getSmallestString(24, 552));
    }
    String res = "";
    public String getSmallestString(int n, int k) {
        dfs(n, k, new StringBuilder());
        return res;
    }

    private boolean dfs(int n, int k, StringBuilder sb) {
        if(n == 0 && k == 0) {
            res = sb.toString();
            return true;
        }
        if(n < 0 || k < 0) return false;
        if(n * 26 < k) return false;
        for (int i = 1; i <= 26; ++i) {
            if(i <= k) {
                StringBuilder append = sb.append((char) ('a' + i - 1));
                if(dfs(n-1, k - i, append)) return true;
                append.deleteCharAt(append.length() - 1);
            }
        }
        return false;
    }
}
