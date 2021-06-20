package com.xinzhe.contest.biweeekly.s1.biweekly15;

/**
 * @author Xin
 * @date 2020/6/6
 * Title : 1287. 有序数组中出现次数超过25%的元素
 * Description : 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。请你找到并返回这个整数
 * link : https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 * Level : Easy
 * Comment 15双周赛01
 */

public class Leetcode_biweekly_1501 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length / 4;
        int count = 0;
        int pre = arr[0];
        for (int i : arr) {
            if (i == pre) {
                count++;
                if (count > n) {
                    return i;
                }
            } else {
                count = 1;
                pre = i;
            }
        }
        return -1;
    }
}
