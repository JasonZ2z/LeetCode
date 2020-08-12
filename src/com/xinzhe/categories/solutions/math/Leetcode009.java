package com.xinzhe.categories.solutions.math;

/**
 * @Author Xin
 * @create 2020/6/10
 * Title : 9. 回文数
 * Description : 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * link : https://leetcode-cn.com/problems/palindrome-number/
 * Level : Easy
 */

public class Leetcode009 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(Integer.MAX_VALUE));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        System.out.println(res);
        return tmp == res;
    }
}
