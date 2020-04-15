package com.xinzhe.categories.solutions.binarysearch.math;

/**
 * @Author Xin
 * @create 2020/4/8 22:03
 * Title : 69. x 的平方根
 * Description : 实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * link : https://leetcode-cn.com/problems/sqrtx
 * Level : Easy
 */
public class Leetcode069 {
    public static void main(String[] args) {
        System.out.println(mySqrt(10));
    }
    public static int mySqrt(int x) {
        int left = 1, right = x>>1;
        while (left < right){
            int mid = left + ((right - left + 1) >>> 1);
            if(mid * mid > x){
                right = mid - 1; //[left, mid-1]
            } else {
                left = mid; //[mid, right]
            }
        }
        return left;
    }
}
