package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @author Xin
 * @date 2020/8/5
 * Title : 326. 3的幂
 * Description :  给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * link : https://leetcode-cn.com/problems/power-of-three/
 */
public class Leetcode326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(243));
    }

    public static boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    static final double EPS = 1e-10;
    public static boolean isPowerOfThree2(int n) {
        if(n <= 0) return false;
        return (Math.log10(n) / Math.log10(3) + EPS) % 1 <= 2 * EPS;
    }
}
