package com.xinzhe.sword.chapter05;

/**
 * @author Xin
 * @date 2020/11/03
 * Title : 面试题 05.06. 整数转换
 * Description : 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * link : https://leetcode-cn.com/problems/convert-integer-lcci/
 * Level : Medium
 */
public class Interview_0506 {
    public static void main(String[] args) {
        Interview_0506 lc = new Interview_0506();
        System.out.println(Integer.toBinaryString(435));
        System.out.println(Integer.toBinaryString(430));
    }
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }
}
