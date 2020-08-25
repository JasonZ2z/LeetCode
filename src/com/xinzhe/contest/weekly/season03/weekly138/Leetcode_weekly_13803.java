package com.xinzhe.contest.weekly.season03.weekly138;

/**
 * @author Xin
 * @date 2020/8/25
 * Title : 1053. 交换一次的先前排列
 * Description : 给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。如果无法这么操作，就请返回原数组。
 * link : https://leetcode-cn.com/problems/previous-permutation-with-one-swap
 * Level : Medium
 */

public class Leetcode_weekly_13803 {
    public static void main(String[] args) {
        Leetcode_weekly_13803 lc = new Leetcode_weekly_13803();
    }
    public int[] prevPermOpt1(int[] a) {
        int n = a.length;
        if(n == 1) return a;
        int last = 0, j = 0;
        boolean flag = true;
        for(int i=0; i<n; i++) {
            if(i + 1 < n && a[i] > a[i+1]) {
                flag = false;
                last = i;
                j = i+1;
            } else {
                if(a[i] > a[j] && a[i] < a[last]) {
                    j = i;
                }
            }
        }
        if(flag) return a;
        a[last] ^= a[j];
        a[j] ^= a[last];
        a[last] ^= a[j];
        return a;
    }
}
