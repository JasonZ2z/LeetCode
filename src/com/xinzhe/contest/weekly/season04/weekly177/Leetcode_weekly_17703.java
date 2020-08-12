package com.xinzhe.contest.weekly.season04.weekly177;

/**
 * @author Xin
 * @date 2020/5/18
 * Title : 1362. 最接近的因数
 * Description : 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 * link : https://leetcode-cn.com/problems/closest-divisors
 * Level : Medium
 * Comment 177周赛03
 */

public class Leetcode_weekly_17703 {
    public int[] closestDivisors(int num) {
        int[] a = get(num + 1);
        int[] b = get(num + 2);

        if (Math.abs(a[0] - a[1]) <= Math.abs(b[0] - b[1])) {
            return a;
        } else {
            return b;
        }
    }

    private int[] get(int i) {
        int mid = (int) Math.sqrt(i);
        for (int j = mid; j >= 1; --j) {
            int tmp = i / j;
            if (tmp * j == i) {
                return new int[]{tmp, j};
            }
        }
        return new int[0];
    }
}
