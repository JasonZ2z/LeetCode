package com.xinzhe.contest.weekly.season03.weekly121;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 982. 按位与为零的三元组
 * Description : 给定一个整数数组 A，找出索引为 (i, j, k) 的三元组，使得：
 *              0 <= i < A.length
 *              0 <= j < A.length
 *              0 <= k < A.length
 *              A[i] & A[j] & A[k] == 0，其中 & 表示按位与（AND）操作符。
 * link : https://leetcode-cn.com/problems/triples-with-bitwise-and-equal-to-zero
 * Level : Easy
 */

//O(n*2^16)
public class Leetcode_weekly_12104 {
    public static void main(String[] args) {
        Leetcode_weekly_12104 lc = new Leetcode_weekly_12104();
        int[] arr = {2,-3,-1,5,-4};
    }

    public int countTriplets(int[] nums) {
        int res = 0;
        int[] dp = new int[1 << 16];
        for (int i : nums) {
            for (int j : nums) {
                dp[i & j]++;
            }
        }
        for (int i = 0; i < 1 << 16; ++i) {
            if(dp[i] == 0) continue;
            for (int num : nums) {
                if((num & i) == 0) res += dp[i];
            }
        }
        return res;
    }
}
