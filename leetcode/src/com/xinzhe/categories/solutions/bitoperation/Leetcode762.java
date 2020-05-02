package com.xinzhe.categories.solutions.bitoperation;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/30 20:52
 * Title : 762. 二进制表示中质数个计算置位
 * Description : 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *              （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 * link : https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 * Level : Easy
 */
public class Leetcode762 {
    public int countPrimeSetBits(int L, int R) {
        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        int count = 0;
        for (int i = L; i <= R; ++i) {
            if(list.contains(Integer.bitCount(i))){
                count++;
            }
        }
        return count;
    }
}
