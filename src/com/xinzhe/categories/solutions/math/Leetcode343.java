package com.xinzhe.categories.solutions.math;

/**
 * @author Xin
 * @date 2020/9/2
 * Title : 343. 整数拆分
 * Description : 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * link : https://leetcode-cn.com/problems/integer-break/
 * Level : Medium
 */

public class Leetcode343 {
    int mod = (int)1e9+7;
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int cnt = n / 3;

        if(n % 3 == 0){
            return (int)(fastPow(3, cnt) % mod);
        }
        if(n % 3 == 1) {
            return (int)((fastPow(3, cnt-1) * 4) % mod);
        }
        return (int)((fastPow(3, cnt) * 2 % mod));
    }

    private long fastPow(long a, int b) {
        if(b == 0) return 1;
        long res = 1;
        while(b != 0) {
            if((b & 1) == 1) {
                res *= a;
                res %= mod;
            }
            a *= a;
            a %= mod;
            b >>= 1;
        }
        return res;
    }
}
