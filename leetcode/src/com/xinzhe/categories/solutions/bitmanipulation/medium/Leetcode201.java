package com.xinzhe.categories.solutions.bitmanipulation.medium;

/**
 * @Author Xin
 * @create 2020/8/5
 * Title : 201. 数字范围按位与
 * Description : 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * link : https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * Level : Medium
 */

public class Leetcode201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift =  0;
        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }
}
