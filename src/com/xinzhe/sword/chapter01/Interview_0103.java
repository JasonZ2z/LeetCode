package com.xinzhe.sword.chapter01;

/**
 * @author Xin
 * @date 2020/6/10
 * Title : 01.03. String to URL LCCI
 * Description : Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * link : https://leetcode-cn.com/problems/string-to-url-lcci
 * Level : Easy
 */
public class Interview_0103 {

    public String replaceSpaces(String s, int length) {
        return s.substring(0, length).replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println((char) 2);
    }
}
