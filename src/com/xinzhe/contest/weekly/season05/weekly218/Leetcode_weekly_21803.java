package com.xinzhe.contest.weekly.season05.weekly218;

/**
 * @author Xin
 * @date 2020/12/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21803 {
    public static void main(String[] args) {
        Leetcode_weekly_21803 lc = new Leetcode_weekly_21803();
        int[] arr = {3,5};
        System.out.println(lc.concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {
        long x = 1;
        int mod = (int)1e9+7;
        for (int i = 2; i <= n; ++i) {
            x <<= Integer.toBinaryString(i).length();
            x %= mod;
            x += i;
        }
        x %= mod;

        return (int) x;
    }
}
