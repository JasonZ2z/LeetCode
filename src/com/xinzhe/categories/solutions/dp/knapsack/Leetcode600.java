package com.xinzhe.categories.solutions.dp.knapsack;

/**
 * @author Xin
 * @date 2020/3/20 18:51
 * Title : 600. 不含连续1的非负整数
 * Description : 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 * link : https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/
 * Level : Hard
 */

//todo need to review
public class Leetcode600 {
    public static void main(String[] args) {
        System.out.println(findIntegers(5));
    }

    public static int findIntegers(int num) {
        int[] dp = new int[num + 1];
        if (num <= 1) return num + 1;
        String numBinaryStr = Integer.toBinaryString(num);
        int numLen = numBinaryStr.length();
        if (numBinaryStr.charAt(1) == '0') {
            return dp[numLen - 1] + findIntegers(num - (1 << (numLen - 1)));
        } else {
            return dp[numLen - 1] + dp[numLen - 2];
        }
    }
}
