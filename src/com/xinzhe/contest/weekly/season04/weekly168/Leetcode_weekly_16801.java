package com.xinzhe.contest.weekly.season04.weekly168;

/**
 * @Author Xin
 * @create 2020/6/01
 * Title : 1295. 统计位数为偶数的数字
 * Description : 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * link : https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 * Level : Easy
 * Comment 168周赛01
 */

public class Leetcode_weekly_16801 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int len = 0;
            while (num > 0) {
                num /= 10;
                len++;
            }
            if ((len & 1) == 0) count++;
        }
        return count;

    }
}
