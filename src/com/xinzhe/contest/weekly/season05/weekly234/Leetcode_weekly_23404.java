package com.xinzhe.contest.weekly.season05.weekly234;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23404 {
    public static void main(String[] args) {
        Leetcode_weekly_23404 lc = new Leetcode_weekly_23404();
        // System.out.println(lc.maxNiceDivisors(5));
        System.out.println(lc.maxNiceDivisors(8));
    }

    static int MOD = (int) 1e9 + 7;
    public int maxNiceDivisors(int m) {
        if (m == 1) return 1;
        long res = 1L;
        if (m % 3 == 1) {
            res <<= 2;
            m -= 4;
            res *= quickPOW(3, m / 3);
            return (int) (res % MOD);
        }
        res = quickPOW(3, m / 3);
        if (m % 3 == 2) res *= 2;
        return (int) (res % MOD);
    }

    public static long quickPOW(long n, long m) {
        long ans = 1L;
        while (m > 0) {
            if (m % 2 == 1)
                ans = (ans * n) % MOD;
            n = (n * n) % MOD;
            m >>= 1;
        }
        return ans;
    }
}
