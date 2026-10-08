package com.xinzhe.undefined.medium;

/**
 * @author Xin
 * @date 2026-09-23
 * Title : 1524. 和为奇数的子数组数目
 * Description : 返回数组中和为奇数的连续子数组数目,结果对 1e9+7 取模。
 * link : https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/
 * Level : Medium
 */
public class Leetcode1524 {
    private static final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        long res = 0;
        int parity = 0;
        long[] count = {1, 0};
        for (int num : arr) {
            parity ^= (num & 1);
            res += count[parity ^ 1];
            count[parity]++;
        }
        return (int) (res % MOD);
    }
}
