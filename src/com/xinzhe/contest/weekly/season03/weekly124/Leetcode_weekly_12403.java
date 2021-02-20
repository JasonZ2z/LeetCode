package com.xinzhe.contest.weekly.season03.weekly124;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 995. K 连续位的最小翻转次数
 * Description : 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *              返回所需的 K 位翻转的次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 * link : https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_12403 {
    public static void main(String[] args) {
        Leetcode_weekly_12403 lc = new Leetcode_weekly_12403();
        int[] arr = {0,0,0,1,0,1,1,0};
        System.out.println(lc.minKBitFlips(arr, 3));
    }

    public int minKBitFlips(int[] arr, int k) {
        int n = arr.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                if(i + k > n) return -1;
                for (int j = i; j < i + k; ++j) {
                    arr[j] ^= 1;
                }
                min++;
            }
        }
        return min;
    }
}
