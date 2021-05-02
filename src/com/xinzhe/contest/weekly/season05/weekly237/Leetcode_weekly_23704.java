package com.xinzhe.contest.weekly.season05.weekly237;

/**
 * @author Xin
 * @date 2021/04/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23704 {
    public static void main(String[] args) {
        Leetcode_weekly_23704 lc = new Leetcode_weekly_23704();

    }

    public int getXORSum(int[] arr1, int[] arr2) {
        int x = 0, y = 0;

        for (int i : arr1) {
            x ^= i;
        }

        for (int i : arr2) {
            y ^= i;
        }
        return x & y;
    }
}
