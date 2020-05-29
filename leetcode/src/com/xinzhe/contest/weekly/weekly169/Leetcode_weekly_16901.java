package com.xinzhe.contest.weekly.weekly169;

/**
 * @Author Xin
 * @create 2020/5/29
 * Title : 1304. 和为零的N个唯一整数
 * Description : 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * link : https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
 * Level : Easy
 * Comment 169周赛01
 */

public class Leetcode_weekly_16901 {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        if ((n & 1) == 0) {
            int val = n / 2 * -1;
            for (int i = 0; i < n; ++i) {
                if (val == 0) val++;
                res[i] = val++;
            }
        } else {
            int val = n / 2 * -1;
            for (int i = 0; i < n; ++i) {
                res[i] = val++;
            }
        }
        return res;
    }
}
