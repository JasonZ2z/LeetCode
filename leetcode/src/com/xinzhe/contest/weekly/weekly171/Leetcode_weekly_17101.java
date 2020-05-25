package com.xinzhe.contest.weekly.weekly171;

/**
 * @Author Xin
 * @create 2020/5/25
 * Title : 1317. 将整数转换为两个无零整数的和
 * Description : 「无零整数」是十进制表示中 不含任何 0 的正整数。给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。如果存在多个有效解决方案，你可以返回其中任意一个。
 * link : https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
 * Level : Easy
 * Comment 171周赛01
 */

public class Leetcode_weekly_17101 {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; ++i) {
            if (helper(i) && helper(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[2];
    }

    public boolean helper(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
