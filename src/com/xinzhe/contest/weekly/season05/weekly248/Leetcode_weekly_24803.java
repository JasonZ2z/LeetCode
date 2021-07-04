package com.xinzhe.contest.weekly.season05.weekly248;

/**
 * @author Xin
 * @date 2021/07/04
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24803 {
    public static void main(String[] args) {
        Leetcode_weekly_24803 lc = new Leetcode_weekly_24803();
        System.out.println(lc.countGoodNumbers(1));
        System.out.println(lc.countGoodNumbers(2));
        System.out.println(lc.countGoodNumbers(4));
        System.out.println(lc.countGoodNumbers(50));
    }

    public int countGoodNumbers(long n) {
        int mod =  (int)1e9 + 7;
        long a ,b ;
        if(n % 2 == 0) {
            a = n / 2;
            b = n / 2;
        } else {
            a = n / 2;
            b = n / 2 + 1;
        }

        return (int) (pow(4, a, mod) * pow(5, b, mod) % mod);
    }

    public long pow(long base, long num, int mod){
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
}
