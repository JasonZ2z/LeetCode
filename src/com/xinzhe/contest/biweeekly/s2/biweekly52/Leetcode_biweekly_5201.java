package com.xinzhe.contest.biweeekly.s2.biweekly52;

/**
 * @author Xin
 * @date 2021/06/12
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5201 {
    public static void main(String[] args) {
        Leetcode_biweekly_5201 lc = new Leetcode_biweekly_5201();
    }
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[50];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; ++i) {
                arr[i] = 1;
            }
        }
        for (int i = left; i <= right; ++i) {
            if(arr[i] == 0) return false;
        }
        return true;
    }
}