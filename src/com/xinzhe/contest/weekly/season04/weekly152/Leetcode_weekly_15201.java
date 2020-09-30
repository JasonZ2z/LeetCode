package com.xinzhe.contest.weekly.season04.weekly152;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 1175. 质数排列
 * Description : 你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *              由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * link : https://leetcode-cn.com/problems/prime-arrangements
 * Level : Easy
 */

public class Leetcode_weekly_15201 {
    public static void main(String[] args) {
        Leetcode_weekly_15201 lc = new Leetcode_weekly_15201();
        System.out.println(lc.numPrimeArrangements(100));
    }
    int mod = (int)1e9 + 7;
    public int numPrimeArrangements(int n) {
        if(n == 1) return 1;
        int count = 0;
        for (int i = 2; i <= n; ++i) {
            if(isPrime(i)) count++;
        }
        System.out.println(count);
        return (int)(calculate(count) * calculate(n - count) % mod);
    }

    private long calculate(int count) {
        long res = 1;
        for (int i = 2; i <= count; ++i) {
            res *= i;
            res %= mod;
        }
        return res;
    }

    private boolean isPrime(int n) {
        for(int i = 2;i <= Math.sqrt(n);i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
