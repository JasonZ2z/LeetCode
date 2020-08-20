package com.xinzhe.sword.chapter05;

/**
 * @author Xin
 * @date 2020/8/17
 * Title : 面试题 05.04. 下一个数
 * Description : 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * link : https://leetcode-cn.com/problems/closed-number-lcci/
 * Level : Medium
 */
public class Interview_0504 {
    public static void main(String[] args) {
        Interview_0504 lc = new Interview_0504();
        System.out.println(Integer.toBinaryString(435));
        System.out.println(Integer.toBinaryString(430));
    }
    public int[] findClosedNumbers(int num) {
        int n = Integer.bitCount(num);
        int before = num;
        long after = num;
        while(--before > 0){
            if(Integer.bitCount(before) == n) {
                break;
            }
        }
        if(before == 0) before = -1;
        while(++after <= Integer.MAX_VALUE){
            if(Integer.bitCount((int)after) == n) {
                break;
            }
        }
        if(after > Integer.MAX_VALUE) after = -1;
        return new int[]{(int)after, before};
    }
}
