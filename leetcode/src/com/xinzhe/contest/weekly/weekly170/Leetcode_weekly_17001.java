package com.xinzhe.contest.weekly.weekly170;

/**
 * @Author Xin
 * @create 2020/5/27
 * Title : 1309. 解码字母到整数映射
 * Description : 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。题目数据保证映射始终唯一。
 * link : https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * Level : Easy
 * Comment 170周赛01
 */

public class Leetcode_weekly_17001 {
    public static void main(String[] args) {
        String s = "10#11#12";
        String[] split = s.split("#");
        System.out.println(freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        if (s.endsWith("#")) {
            s = s + "$";
        }
        String[] arr = s.split("#");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            int n = arr[i].length();
            if (n > 2) {
                sb.append(helper(arr[i].substring(0, arr[i].length() - 2)));
                sb.append((char) (Integer.parseInt(arr[i].substring(arr[i].length() - 2)) - 1 + 'a'));
            } else {
                sb.append((char) (Integer.parseInt(arr[i]) - 1 + 'a'));
            }
        }

        if (!"$".equals(arr[arr.length - 1])) {
            sb.append(helper(arr[arr.length - 1]));
        }
        return sb.toString();
    }

    private static String helper(String s) {
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            res.append((char) (Integer.parseInt(c + "") - 1 + 'a'));
        }
        return res.toString();
    }
}
