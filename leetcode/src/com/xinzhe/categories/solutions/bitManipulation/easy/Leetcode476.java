package com.xinzhe.categories.solutions.bitManipulation.easy;

/**
 * @Author Xin
 * @create 2020/4/29
 * Title : 476. 数字的补数
 * Description : 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * link : https://leetcode-cn.com/problems/number-complement/
 * Level : Easy
 */

public class Leetcode476 {
    public static void main(String[] args) {
        System.out.println(findComplement(2));
    }
    public static int findComplement(int num) {
        int res = 0;
        int tmp = 1;
        while(num != 0) {
            if((num & 1) == 0) {
                res = res | tmp;
            }
            tmp <<= 1;
            num >>= 1;
        }
        return res;
    }
}
