package com.xinzhe.categories.solutions.math;

/**
 * @author Xin
 * @date 2020/8/19
 * Title : 快速幂
 * Description : (a ^ b) % mod
 * link : https://leetcode-cn.com/problems/palindrome-number/
 * Level : Easy
 */

public class FastPower {
    public static int fastPower(int a, int b, int mod) {
        if(b == 0) return 1 % mod;
        long ans = 1;
        while (b != 0) {
            if((b & 1) == 1) ans = (ans * a) % mod;
            a = (a % mod) * (a % mod) % mod;
            b >>= 1;
        }
        return (int)ans;
    }

    public static int fastPower(int a, int b) {
        if(b == 0) return 1;
        long ans = 1;
        while (b != 0) {
            if((b & 1) == 1) ans = (ans * a) ;
            a *= a;
            b >>= 1;
        }
        return (int)ans;
    }

    private long pow(long base, int num, int mod){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fastPower(2, 12));
    }
}
