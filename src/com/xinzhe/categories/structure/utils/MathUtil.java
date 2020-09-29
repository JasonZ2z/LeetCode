package com.xinzhe.categories.structure.utils;

/**
 * @author xzheng
 */
public class MathUtil {
    //质数判断
    private static boolean isPrime(int n) {
        for(int i = 2;i <= Math.sqrt(n);i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    //公约数
    private static int gcd(int a, int b){
        return a==0? b : gcd(b%a , a);
    }

    //公倍数
    public static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    //交换数组元素
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 快速幂 a ^ b % mod
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

    //组合求方案数 C(n,k)
    private static long combination(int n, int k) {
        long a=1, b=1;
        if(k > n/2) k = n-k;
        for(int i = 1; i <= k; i++) {
            a *= (n+1-i);
            b *= i;
        }
        return a/b;
    }

    //计算A运算
    private static int calcu_A(int n, int m) {
        int res = n, temp = n-1;
        for(int i = 1; i < m; i++) {
            res *= temp;
            temp -= 1;
        }
        return res;
    }

    //计算C运算
    private static int calcu_C(int n, int m) {
        if(m == 0) return 1;
        return calcu_A(n, m) / calcu_A(m, m);
    }
}
