package com.xinzhe.contest.biweeekly.biweekly35;

/**
 * @author Xin
 * @date 2020/9/19
 * Title : 1588. 所有奇数长度子数组的和
 * Description : 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *              子数组 定义为原数组中的一个连续子序列。请你返回 arr 中 所有奇数长度子数组的和 。
 * link : https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * Level : Easy
 */
public class Leetcode_biweekly_3501 {
    public static void main(String[] args) {
        Leetcode_biweekly_3501 lc = new Leetcode_biweekly_3501();
        int[] arr = {1,4,2,5,3};
        System.out.println(lc.sumOddLengthSubarrays(arr));
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n+1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        for (int i = 1; i <= n; i+=2) {
            for (int j = 0; j+i <= n; j++) {
                ans += pre[j+i] - pre[j];
            }
        }
        return ans;
    }
}
