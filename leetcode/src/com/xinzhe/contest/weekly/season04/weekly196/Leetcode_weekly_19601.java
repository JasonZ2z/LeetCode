package com.xinzhe.contest.weekly.season04.weekly196;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/7/5
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 196周赛01
 */
public class Leetcode_weekly_19601 {
    public static void main(String[] args) {
        Leetcode_weekly_19601 lc = new Leetcode_weekly_19601();
    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length == 2) return true;
        Arrays.sort(arr);
        int tmp = arr[1] -arr[0];

        for (int i = 2; i < arr.length; ++i) {
            if(arr[i] - arr[i-1]  !=  tmp) {
                return false;
            }
        }
        return true;

    }
}
