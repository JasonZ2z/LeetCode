package com.xinzhe.contest.weekly.season03.weekly126;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1004. 最大连续1的个数 III
 * Description : 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。返回仅包含 1 的最长（连续）子数组的长度。
 * link : https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * Level : Medium
 */

public class Leetcode_weekly_12603 {
    public static void main(String[] args) {
        Leetcode_weekly_12603 lc = new Leetcode_weekly_12603();
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(lc.longestOnes(arr, 2));
    }

    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = 0, c = 0, max = 0;
        while(r < n) {
            if(arr[r] == 0) c++;
            while(c > k) {
                if(arr[l++] == 0) c--;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
