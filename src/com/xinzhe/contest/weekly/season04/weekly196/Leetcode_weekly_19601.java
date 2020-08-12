package com.xinzhe.contest.weekly.season04.weekly196;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/7/5
 * Title : 1502. 判断能否形成等差数列
 * Description : 给你一个数字数组 arr 。如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * link : https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
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
