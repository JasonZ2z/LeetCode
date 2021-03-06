package com.xinzhe.contest.biweeekly.s1.biweekly33;

/**
 * @author Xin
 * @date 2020/8/22
 * Title : 1556. 千位分隔数
 * Description :  给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 * link : https://leetcode-cn.com/problems/thousand-separator/
 * Level : Easy
 */
public class Leetcode_biweekly_3301 {
    public static void main(String[] args) {
        Leetcode_biweekly_3301 lc = new Leetcode_biweekly_3301();
        System.out.println(lc.thousandSeparator(1234));
    }
    public String thousandSeparator(int n) {
        if(n < 1000) return String.valueOf(n);
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i-=3) {
            sb.append(arr[i]);
            if(i-1 >=0)sb.append(arr[i-1]);
            if(i-2>=0)sb.append(arr[i-2]);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
}
