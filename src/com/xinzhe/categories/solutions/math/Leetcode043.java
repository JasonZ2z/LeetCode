package com.xinzhe.categories.solutions.math;

import java.math.BigInteger;

/**
 * @author Xin
 * @date 2020/8/13
 * Title : 43. 字符串相乘
 * Description : 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * link : https://leetcode-cn.com/problems/multiply-strings/
 * Level : Medium
 */

public class Leetcode043 {

    /**
     * 要求是不能用BigInteger
     * 解法就是模拟乘法的过程，先逐位相乘，末尾补零，乘法结果逐个相加。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
         return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int len2 = num2.length();

        String[] res = new String[len2];

        for(int i = len2-1; i >= 0; --i) {
            res[i] = arr2[i] == '0' ? "0" : multi(arr1, arr2[i] - '0') + "0".repeat(len2 - 1 -i);
        }
        String ans = res[0];
        for (int i = 1; i < len2; ++i) {
            ans = add(ans, res[i]);
        }
        return ans;
    }

    private String add(String s1, String s2) {
        if("0".equals(s1)) return s2;
        if("0".equals(s2)) return s1;
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        int p = s1.length()-1, q = s2.length()-1;
        while(p >=0 || q >= 0) {
            int x = p >= 0 ? s1.charAt(p) - '0' : 0;
            int y = q >= 0 ? s2.charAt(q) - '0' : 0;
            int tmp = x + y + carrier;
            sb.append(tmp % 10);
            carrier = tmp / 10;
            p--;
            q--;
        }
        if(carrier > 0) sb.append(carrier);
        return sb.reverse().toString();
    }

    private String multi(char[] arr, int c) {
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = (arr[i] - '0') * c + carrier;
            sb.append(tmp % 10);
            carrier = tmp / 10;
        }
        if(carrier > 0) sb.append(carrier);
        return sb.reverse().toString();
    }
}
