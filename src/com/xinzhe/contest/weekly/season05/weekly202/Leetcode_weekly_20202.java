package com.xinzhe.contest.weekly.season05.weekly202;

/**
 * @author Xin
 * @date 2020/8/16
 * Title : 1551. 使数组中所有元素相等的最小操作数
 * Description : 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
 *          一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。
 *          最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
 *          给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
 * link : https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal
 * Level : Medium
 */
public class Leetcode_weekly_20202 {
    public static void main(String[] args) {
        Leetcode_weekly_20202 lc = new Leetcode_weekly_20202();
    }

    public int minOperations(int n) {
        int res = 0;
        if(n % 2 == 1) {
            for (int i = 0; i < n / 2; ++i) {
                res += n - i * 2;
            }
        } else {
            for (int i = 0; i < n / 2; ++i) {
                res += n - i * 2 + 1;
            }
        }
        return res;
    }
}
