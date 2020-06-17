package com.xinzhe.contest.weekly.season04.weekly166;

/**
 * @Author Xin
 * @create 2020/6/03
 * Title : 1281. 整数的各位积和之差
 * Description : 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * link : https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * Level : Easy
 * Comment 166周赛01
 */

public class Leetcode_weekly_16601 {
    public int subtractProductAndSum(int n) {
        int muti = 1;
        int sum = 0;
        while (n != 0) {
            muti *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return muti - sum;
    }
}
