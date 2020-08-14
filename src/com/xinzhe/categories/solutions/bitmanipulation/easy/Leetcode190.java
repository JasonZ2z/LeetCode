package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @author Xin
 * @date 2020/8/14
 * Title :190. 颠倒二进制位
 * Description : 颠倒给定的 32 位无符号整数的二进制位。
 * link : https://leetcode-cn.com/problems/reverse-bits/
 * Level : Easy
 */
//todo need to review
public class Leetcode190 {
    public static void main(String[] args) {
        Leetcode190 lc = new Leetcode190();
        System.out.println(lc.reverseBits(-1));
    }
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if(((n >> i) & 1) == 1) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }
}
