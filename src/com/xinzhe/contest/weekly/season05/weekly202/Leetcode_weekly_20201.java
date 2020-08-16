package com.xinzhe.contest.weekly.season05.weekly202;

/**
 * @author Xin
 * @date 2020/8/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20201 {
    public static void main(String[] args) {
        Leetcode_weekly_20201 lc = new Leetcode_weekly_20201();
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 2; ++i) {
            if(arr[i] % 2 == 1 && arr[i+1] % 2 == 1  && arr[i+2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
