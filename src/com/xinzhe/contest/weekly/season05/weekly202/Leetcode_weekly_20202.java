package com.xinzhe.contest.weekly.season05.weekly202;

/**
 * @author Xin
 * @date 2020/8/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20202 {
    public static void main(String[] args) {
        Leetcode_weekly_20202 lc = new Leetcode_weekly_20202();
    }

    public int minOperations(int n) {
        int res = 0;
        if(n % 2 == 1) {
            for (int i = 0; i < n / 2; ++i) {
                res += n - i * 2;
            }
        } else {
            for (int i = 0; i < n / 2; ++i) {
                res += n - i * 2 + 1;
            }
        }
        return res;
    }
}
