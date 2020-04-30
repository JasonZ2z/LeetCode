package com.xinzhe.order.day11;

/**
 * @author Xin
 * @create 2020/4/24
 * Title : 1422. 分割字符串的最大得分
 * Description : 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * link : https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string
 * Level : Easy
 * Comment : 186周赛01
 */

public class Leetcode_weekly_18601 {
    public static void main(String[] args) {
        Leetcode_weekly_18601 lc = new Leetcode_weekly_18601();
        System.out.println(lc.maxScore("00"));
    }
    public int maxScore(String s) {
        int n = s.length();
        int[] dp_0 = new int[n];
        int[] dp_1 = new int[n];
        if(s.startsWith("0")) {
            dp_0[0] = 1;
        } else {
            dp_0[0] = 0;
        }
        if(s.endsWith("1")) {
            dp_1[n-1] = 1;
        } else {
            dp_1[n-1] = 0;
        }

        for (int i = 1; i < n; ++i) {
            if(s.charAt(i) == '0') {
                dp_0[i] = dp_0[i-1] + 1;
            } else {
                dp_0[i] = dp_0[i-1];
            }
        }

        for(int i = n-2; i >= 0; --i) {
            if(s.charAt(i) == '1') {
                dp_1[i] = dp_1[i+1] + 1;
            } else {
                dp_1[i] = dp_1[i+1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; ++i) {
            max = Math.max(dp_0[i]+dp_1[i+1] , max);
        }
        return max;
    }
}
