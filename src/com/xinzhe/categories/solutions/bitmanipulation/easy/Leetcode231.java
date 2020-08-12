package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @author Xin
 * @date 2020/8/5
 * Title : 231. 2的幂
 * Description :  给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * link : https://leetcode-cn.com/problems/power-of-two/
 */
public class Leetcode231 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(Integer.bitCount(2147483647));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(isPowerOfTwo(-2147483648));
        System.out.println(Integer.sum(1, 2));
        System.out.println(Integer.toBinaryString(Integer.reverse(2)));
        System.out.println(Integer.lowestOneBit(12));
    }
    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return Integer.bitCount(n) == 1;
    }

    public static boolean isPowerOfTwo2(int n) {
        if(n <= 0) return false;
        System.out.println(Integer.sum(1, 2));
        return Integer.highestOneBit(n) == n;
    }

    public boolean isPowerOfTwo3(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }
}
