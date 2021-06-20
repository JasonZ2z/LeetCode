package com.xinzhe.contest.biweeekly.s1.biweekly37;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/17
 * Title : 1619. 删除某些元素后的数组均值
 * Description : 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。与 标准答案 误差在 10-5 的结果都被视为正确结果。
 * link : https://leetcode-cn.com/problems/mean-of-array-after-removing-some-elements/
 * Level : Easy
 */
public class Leetcode_biweekly_3701 {
    public static void main(String[] args) {

    }
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int x = (int)(n * 0.05);
        double c  = (n * 0.9);
        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < x; ++i) {
            sum -= arr[i] + arr[n-i-1];
        }
        return sum / c;
    }
}
