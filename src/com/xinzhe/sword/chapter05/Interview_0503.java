package com.xinzhe.sword.chapter05;

/**
 * @author Xin
 * @date 2020/11/03
 * Title : 面试题 05.03. 翻转数位
 * Description : 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * link : https://leetcode-cn.com/problems/reverse-bits-lcci/
 * Level : Easy
 */

public class Interview_0503 {
    public static void main(String[] args) {
        Interview_0503 lc = new Interview_0503();
        System.out.println(lc.reverseBits(-1));
    }
    public int reverseBits(int num) {
        if(num == -1) return 32;
        String s = Integer.toBinaryString(num);
        int pre = 0, max = 1, cur = 1, countZeros = 0;
        boolean oneZero = false;
        for (int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == '1') {
                cur++;
                if(s.charAt(i-1) == '0') {
                    oneZero = countZeros == 1;
                    countZeros = 0;
                }
                if(oneZero) max = Math.max(max, pre + cur + 1);
                max = Math.max(max, cur + 1);
            } else  {
                countZeros++;
                if(s.charAt(i-1) == '1') {
                    pre = cur;
                    cur = 0;
                }
            }
        }
        return max;
    }

    public int reverseBits2(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}
