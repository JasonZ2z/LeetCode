package com.xinzhe.categories.solutions.math;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 372. 超级次方
 * Description : 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * link : https://leetcode-cn.com/problems/super-pow/
 * Level : Medium
 */

public class Leetcode372 {
    public static void main(String[] args) {
    }
    static final int M = 1337;
    public int normalPow(int a, int b) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0)
                result = result * a % M;
            a = a * a % M;
            b /= 2;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        a %= M;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) % M;
            a = normalPow(a, 10);
        }
        return result;
    }
}
