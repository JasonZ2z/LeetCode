package com.xinzhe.contest.weekly.season03.weekly120;

/**
 * @author Xin
 * @date 2020/20/21
 * Title : 978. 最长湍流子数组
 * Description : 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *              若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 *              或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 *              也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。返回 A 的最大湍流子数组的长度
 * link : https://leetcode-cn.com/problems/longest-turbulent-subarray
 * Level : Medium
 */

public class Leetcode_weekly_12002 {
    public static void main(String[] args) {
        Leetcode_weekly_12002 lc = new Leetcode_weekly_12002();
    }
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int l = 0, max = 0;
        boolean flag = false;
        for(int i=1; i<n-1; i++) {
            if((arr[i] > arr[i-1] && arr[i] > arr[i+1]) || (arr[i] < arr[i-1] && arr[i] < arr[i+1])) {
                if(!flag) {
                    flag = true;
                    l = i;
                    max = Math.max(1, max);
                }
                else {
                    max = Math.max(max, i - l  + 1);
                }
            } else {
                flag = false;
            }
        }
        if(max == 0) {
            for (int i = 0; i < n-1; ++i) {
                if(arr[i] != arr[i+1]) return 2;
            }
        }
        return max > 0 ? max + 2 : 1;
    }
}
