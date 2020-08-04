package com.xinzhe.sword.chapter16;

/**
 * @Author Xin
 * @create 2020/6/22
 * Title : 16.18. 模式匹配
 * Description : 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 *              例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * link : https://leetcode-cn.com/problems/pattern-matching-lcci
 * Level : Medium
 */

public class Interview_1618 {
    public static void main(String[] args) {
        System.out.println(patternMatching("abb",
                "dryqxzysggjljxdxag"));
    }
    public static boolean patternMatching(String pattern, String value) {
        int a = 0, b= 0;
        int n = value.length();
        char[] parr = pattern.toCharArray();
        for (char c : parr) {
            if(c == 'a') a++;
            else b++;
        }
        if(a == 0 && b == 0) return n == 0;
        if(a == 0|| b == 0) {
            int tmp = a > 0 ? a : b;
            return eitherZero(tmp, value);
        }
        if(n == 0) return false;
        if(pattern.startsWith("a")) {
            int bStartIndex = pattern.indexOf("b");
            for (int i = 0; i <= n; ++i) {
                if(checkA(i, a, b, bStartIndex, parr, value)){
                    return true;
                }
            }
        } else {
            int aStartIndex = pattern.indexOf("a");
            for (int i = 0; i <= n; ++i) {
                if(checkB(i, a, b, aStartIndex, parr, value)){
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean checkA(int alen, int asize, int bsize, int bStartIndex, char[] pattern, String value) {
        int n = value.length();
        int res = n - alen * asize;
        if(res < 0 || (res % bsize) != 0) return false;
        int blen = res / bsize;
        String aStr = value.substring(0, alen);

        int bStart = bStartIndex * alen;
        String bStr = value.substring(bStart, bStart + blen);
        StringBuilder sb = new StringBuilder();
        for (char c : pattern) {
            if(c == 'a') sb.append(aStr);
            else sb.append(bStr);
        }
        return sb.toString().equals(value);
    }

    private static boolean checkB(int blen, int asize, int bsize, int aStartIndex, char[] pattern, String value) {
        int n = value.length();
        int res = n - blen * bsize;
        if(res < 0 || (res % asize) != 0) return false;
        int alen = res / asize;
        String bStr = value.substring(0, blen);

        int aStart = aStartIndex * blen;
        String aStr = value.substring(aStart, aStart + alen);
        StringBuilder sb = new StringBuilder();
        for (char c : pattern) {
            if(c == 'a') sb.append(aStr);
            else sb.append(bStr);
        }
        return sb.toString().equals(value);
    }

    private static boolean eitherZero(int size, String value) {
        int length = value.length();
        if((length % size) != 0) return false;
        int each = length / size;
        String pat =  value.substring(0, each);
        for (int i = 1; i < size; ++i) {
            String tmpStr = value.substring(each * i, each * (i + 1));
            if(!tmpStr.equals(pat)) return false;
        }
        return true;
    }
}
