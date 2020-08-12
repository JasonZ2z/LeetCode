package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @Author Xin
 * @create 2020/8/5
 * Title : 342. 4的幂
 * Description :  给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * link : https://leetcode-cn.com/problems/power-of-four/
 */
public class Leetcode342 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(0x55555555).length());
        System.out.println(Integer.toBinaryString(0xaaaaaaaa));
        System.out.println(Integer.toBinaryString(0xaaaaaaaa).length());
    }
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        return (Math.log10(num)/Math.log10(4)) % 1 == 0;
    }

    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
