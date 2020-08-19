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

    public double myPow2(double x, int n) {
        if(n == 0 || x == 1.0) return 1;
        if(x == 0) return 0;
        if(n == 1) return x;
        long b = n;
        if(b < 0) {
            x = 1/x;
            b = -b;
        }

        double ans = 1.0;
        while(b != 0) {
            if((b&1) == 1) ans = ans * x;
            b >>= 1;
            x *= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode050 lc = new Leetcode050();
        System.out.println(lc.myPow2(2.0, 2));
    }
}
