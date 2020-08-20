package com.xinzhe.sword.chapter05;

/**
 * @author Xin
 * @date 2020/8/17
 * Title : 面试题 05.07. 配对交换
 * Description : 交换某个整数的奇数位和偶数位
 * link : https://leetcode-cn.com/problems/exchange-lcci/
 * Level : Easy
 */
public class Interview_0507 {
    public static void main(String[] args) {
        Interview_0507 lc = new Interview_0507();
        System.out.println(lc.exchangeBits(2));
    }

    public int exchangeBits(int num) {
        for(int i=0; i<32; i+=2) {
            if((((num >>> i) & 1)^((num>>>(i+1) & 1)))== 1) {
                num ^= 1 << i;
                num ^= 1 << (i+1);
            }
        }
        return num;
    }
}
