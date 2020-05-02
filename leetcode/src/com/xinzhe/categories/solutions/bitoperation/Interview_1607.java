package com.xinzhe.categories.solutions.bitoperation;

/**
 * @Author Xin
 * @create 2020/4/30
 * Title : 面试题 16.07. 最大数值
 * Description : 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * link : https://leetcode-cn.com/problems/maximum-lcci/
 * Level : Easy
 */
public class Interview_1607 {
    public static void main(String[] args) {
        System.out.println(maximum(Integer.MAX_VALUE,Integer.MIN_VALUE));
    }
    public static int maximum(int a, int b) {
        long l = ((long) a - (long) b) >>> 63;
        System.out.println(l);
        // l == 0  -> a
        // l == 1  -> b
        return (int)(a * (1 - l) + b * l);
    }
}
