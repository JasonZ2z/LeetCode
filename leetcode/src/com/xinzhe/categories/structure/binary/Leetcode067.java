package com.xinzhe.categories.structure.binary;

/**
 * @Author Xin
 * @create 2020/6/23
 * Title :67. 二进制求和
 * Description : 给你两个二进制字符串，返回它们的和（用二进制表示）。输入为 非空 字符串且只包含数字 1 和 0。
 * link : https://leetcode-cn.com/problems/add-binary/
 * Level : Easy
 */

public class Leetcode067 {
    public static String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        int carrier = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < alen || i < blen) {
            int avar = alen - i -1 >= 0 ? arr[alen - i -1] - '0' : 0;
            int bvar = blen - i -1 >= 0 ? brr[blen - i -1] - '0' : 0;
            int tmp  = avar + bvar + carrier;
            carrier = tmp / 2 ;
            sb.insert(0, tmp%2);
            i++;
        }
        if(carrier > 0) {
            sb.insert(0, carrier);
        }
        return sb.toString();
    }
}
