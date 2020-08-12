package com.xinzhe.contest.biweeekly.biweekly27;

/**
 * @author Xin
 * @date 2020/5/30
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_2701 {
    public static void main(String[] args) {
        int[] t = {3, 7, 9};
        int[] a = {3, 7, 11};
        System.out.println(canBeEqual(t, a));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (arr.length != target.length) return false;
        int n = target.length;
        int[] a1 = new int[1001];
        int[] a2 = new int[1001];
        for (int i = 0; i < n; ++i) {
            a1[arr[i]]++;
            a2[target[i]]++;
        }
        for (int i = 0; i < 1001; ++i) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

}
