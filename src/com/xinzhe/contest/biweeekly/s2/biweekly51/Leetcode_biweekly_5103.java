package com.xinzhe.contest.biweeekly.s2.biweekly51;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/05/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5103 {
    public static void main(String[] args) {
        Leetcode_biweekly_5103 lc = new Leetcode_biweekly_5103();
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }

}