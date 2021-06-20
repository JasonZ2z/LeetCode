package com.xinzhe.contest.biweeekly.s2.biweekly51;

/**
 * @author Xin
 * @date 2021/05/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5101 {
    public static void main(String[] args) {
        Leetcode_biweekly_5101 lc = new Leetcode_biweekly_5101();
    }
    public String replaceDigits(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 1; i < n; i+=2) {
            arr[i] = (char) (arr[i-1] + arr[i] - '0');
        }
        return new String(arr);
    }
}