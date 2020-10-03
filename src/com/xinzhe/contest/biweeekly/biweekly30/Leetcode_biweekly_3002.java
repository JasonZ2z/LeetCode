package com.xinzhe.contest.biweeekly.biweekly30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/11
 * Title : 1508. 子数组和排序后的区间和
 * Description : 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
 *              请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * link : https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums
 * Level : Medium
 */
public class Leetcode_biweekly_3002 {
    public static void main(String[] args) {
        Leetcode_biweekly_3002 lc = new Leetcode_biweekly_3002();
        int[] arr = {1,2,3,4};
        System.out.println(lc.rangeSum(arr, 4, 1, 10));
    }

    static final int MOD = (int) (1e9 +7);
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int j = i;
            int tmp = 0;
            while (j < n) {
                tmp += nums[j++];
                list.add(tmp);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        long sum = 0;
        for (int i = left-1; i < right; ++i) {
            sum += list.get(i);
        }
        return (int)sum % MOD;
    }
}
