package com.xinzhe.order.day05;

/**
 * @author Xin
 * @date 2020/3/12 16:54
 * Title : 1071. 字符串的最大公因子
 * Description : 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *              返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *          输入：str1 = "ABCABC", str2 = "ABC"
 *          输出："ABC"
 * link : https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * Level : Easy
 */
public class Leetcode1071 {
    public static void main(String[] args) {
        String s1 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String s2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(s1,s2));
        System.out.println(gcdOfStrings2(s1,s2));

    }
    //辗转相除
    public static String gcdOfStrings2(String str1, String str2) {
        if(str1 == null || str2 == null) return "";
        if(!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str2.length(), str1.length()));
    }

    private static int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }


    //暴力
    public static String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str2 == null) return "";

        String tmp = "";
        if("".equals(str1.replace(str2, ""))) return str2;

        for (int i = 1; i < str2.length(); i++) {
            tmp = str2.substring(0,i);
            if("".equals(str2.replace(tmp, ""))){
                break;
            }
        }
        if(!"".equals(str1.replace(tmp, ""))) return "";

        int size = str2.length()/tmp.length();
        int i = size-1;
        for (; i > 0; i--) {
            if("".equals(str1.replace(tmp.repeat(i), "")) && "".equals(str2.replace(tmp.repeat(i), ""))) {
                break;
            }
        }
        return tmp.repeat(i);
    }
}
