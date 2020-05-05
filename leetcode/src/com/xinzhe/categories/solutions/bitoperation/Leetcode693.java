package com.xinzhe.categories.solutions.bitoperation;

/**
 * @Author Xin
 * @create 2020/5/2
 * Title : 693. 交替位二进制数
 * Description : 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * link : https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * Level : Easy
 */
public class Leetcode693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        //System.out.println(1);
    }
    public static boolean hasAlternatingBits(int n) {
        if(n == 1) return true;
        int res = n & 1;
        n >>= 1;
        while(n > 0) {
            if((n & 1) == res) {
                return false;
            } else {
                res = n & 1;
                n >>= 1;
            }
        }
        return true;
    }
}
