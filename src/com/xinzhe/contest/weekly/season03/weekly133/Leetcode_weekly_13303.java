package com.xinzhe.contest.weekly.season03.weekly133;

/**
 * @author Xin
 * @date 20209/10
 * Title : 1031. 两个非重叠子数组的最大和
 * Description : 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
 *              从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：
 *              0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 *              0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 * link : https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays
 * Level : Medium
 */

public class Leetcode_weekly_13303 {
    public static void main(String[] args) {
        Leetcode_weekly_13303 lc = new Leetcode_weekly_13303();
        int[] arr = {8,20,6,2,20,17,6,3,20,8,12};
        System.out.println(lc.maxSumTwoNoOverlap(arr, 5, 4));
    }
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            pre[i+1] = pre[i] + A[i];
        }
        int res = 0, left =0;
        for (int i = 0; i + L + M <= n; ++i) {
            left = Math.max(pre[i+L] - pre[i], left);
            res = Math.max(helper(A, M, i+L, n-1) + left, res);
        }
        left = 0;
        for (int i = 0; i + L + M <= n; ++i) {
            left = Math.max(pre[i+M] - pre[i], left);
            res = Math.max(helper(A, L, i+M, n-1) + left, res);
        }
        return res;

    }
    private int helper(int[] arr, int len, int l, int r) {
        if(r - l + 1 < len) return  0;
        else if(r - l + 1 == len) {
            int sum = 0;
            for(int i = l; i <= r; i++) {
                sum += arr[i];
            }
            return sum;
        }else {
            int max = 0, sum = 0;
            int p=l, q= l;
            while(q <= r) {
                while(q - p < len) {
                    sum += arr[q++];
                }
                if(sum > max) {
                    max = sum;
                }
                if(q - p == len) {
                    sum -= arr[p++];
                }
            }
            return max;
        }
    }
}
