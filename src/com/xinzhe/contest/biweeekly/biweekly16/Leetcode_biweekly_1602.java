package com.xinzhe.contest.biweeekly.biweekly16;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/5/29
 * Title : 1300. 转变数组后最接近目标值的数组和
 * Description : 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 请注意，答案不一定是 arr 中的数字。
 * link : https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * Level : Medium
 * Comment 16双周赛02
 */

public class Leetcode_biweekly_1602 {
    public static void main(String[] args) {
        int[] arr = {60864, 25176, 27249, 21296, 20204};
        System.out.println(findBestValue(arr, 56803));
    }

    public static int findBestValue(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        if (sum < target) return -1;
        int left = 0, right = arr[n - 1];
        int min = Integer.MAX_VALUE;
        int index = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tmp = getSum(arr, mid);
            int abs = Math.abs(tmp - target);
            if (abs <= min) {
                if (abs == min) index = Math.min(index, mid);
                else {
                    min = abs;
                    index = mid;
                }
            }
            if (tmp > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int abs = Math.abs(getSum(arr, left) - target);
        if (abs == min) return Math.min(left, index);
        if (abs < min) return left;
        return index;
    }

    private static int getSum(int[] arr, int mid) {
        int sum = 0;
        for (int value : arr) {
            sum += Math.min(value, mid);
        }
        return sum;
    }
}
