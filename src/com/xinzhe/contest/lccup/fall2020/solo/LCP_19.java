package com.xinzhe.contest.lccup.fall2020.solo;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/12
 * Title : LCP 19. 秋叶收藏集
 * Description : 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 *              出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
 *              请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 * link : https://leetcode-cn.com/problems/UlBDOe
 * Level : Medium
 */
//todo need to review
public class LCP_19 {
    public static void main(String[] args) {
        LCP_19 lc = new LCP_19();
        System.out.println(lc.minimumOperations("rrryyyrryyyrr"));
        System.out.println(lc.minimumOperations("ryr"));
        System.out.println(lc.minimumOperations("yry"));
        System.out.println(lc.minimumOperations("yyyrrrrryyrrryyyy"));
    }

    public int minimumOperations(String leaves) {
        int n = leaves.length();
        char[] arr = leaves.toCharArray();
        int[][] dp = new int[n][3];
        for (int[] a : dp) {
            Arrays.fill(a, (int) 1e9);
        }
        dp[0][0] = arr[0] == 'r' ? 0 : 1;
        for (int i = 1; i < n; ++i) {
            if(arr[i] == 'r') {
                dp[i][0] = dp[i-1][0]; //r
                dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]) + 1; //y
                dp[i][2] = Math.min(dp[i-1][2], dp[i-1][1]); //r
            }else { //y
                dp[i][0] = dp[i-1][0] + 1;  //r
                dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]); //y
                dp[i][2] = Math.min(dp[i-1][2], dp[i-1][1]) + 1; //r
            }
        }
        return dp[n-1][2];
    }
}
