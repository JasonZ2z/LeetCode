package com.xinzhe.sword.chapter01;

import java.util.BitSet;

/**
 * @author Xin
 * @date 2020/6/10
 * Title : 01.01. Is Unique LCCI
 * Description : Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * link : https://leetcode-cn.com/problems/is-unique-lcci/
 * Level : Easy
 */
public class Interview_0101 {
    /**
     * ASCII码字符个数一共128个，用两个64位的long变量来存储是否出现某个字符
     */
    //todo need to review
    public boolean isUnique(String astr) {
        long a = 0L, b = 0L;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bit = 1L << (c - 64);
                if ((b & bit) != 0) {
                    return false;
                }
                b |= bit;
            } else {
                long bit = 1L << c;
                if ((a & bit) != 0) {
                    return false;
                }
                a |= bit;
            }
        }
        return true;
    }

    public boolean isUnique2(String astr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < astr.length(); ++i) {
            if (bitSet.get(astr.charAt(i))) {
                return false;
            }
            bitSet.set(astr.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((char) 2);
    }
}
