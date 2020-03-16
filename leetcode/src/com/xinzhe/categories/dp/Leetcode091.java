package com.xinzhe.categories.dp;

/**
 * @Author Xin
 * @create 2020/3/16 18:11
 * Title : 91. 解码方法
 * Description : 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * link : https://leetcode-cn.com/problems/decode-ways
 * Level : Medium
 */
public class Leetcode091 {
    public static void main(String[] args) {
        String s = "100";
        System.out.println(numDecodings(s));
    }
    // 这道题用逆序最优
    public static int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(s.startsWith("0")) return 0;
        if(n == 1) return 1;
        char[] chars = s.toCharArray();
        int[] dp = new int[n+1];
        dp[n] = 1;
        if(chars[n-1] == '0') {
            dp[n-1] = 0;
        } else {
            dp[n-1] = 1;
        }
        for (int i = n-2; i >= 0 ; i--) {
            if(chars[i] == '0') continue;
            if(((chars[i] - '0')* 10 + (chars[i+1]- '0') ) > 26) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = dp[i+1] + dp[i+2];
            }
        }
        return dp[0];
    }
}
