package com.xinzhe.categories.solutions.binarysearch.math;

/**
 * @author Xin
 * @date 2020/4/14 21:41
 * Title : 50. Pow(x, n)
 * Description : 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * Level : Medium
 */

public class Leetcode050 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }
}
