package com.xinzhe.contest.weekly.season06.weekly252;

/**
 * @author Xin
 * @date 2021/08/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25201 {
    public static void main(String[] args) {
        Leetcode_weekly_25201 lc = new Leetcode_weekly_25201();

    }
    public boolean isThree(int n) {
        if(n < 4) return false;
        int v = (int) Math.sqrt(n);
        return isPrime(v) && v*v == n;
    }

    private boolean isPrime(int n) {
        for(int i = 2;i <= Math.sqrt(n);i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
