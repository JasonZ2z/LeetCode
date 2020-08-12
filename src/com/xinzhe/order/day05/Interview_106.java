package com.xinzhe.order.day05;

/**
 * @author Xin
 * @date 2020/3/16 18:01
 * Title : 面试题 01.06. 字符串压缩
 * Description : 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 *              比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * link : https://leetcode-cn.com/problems/compress-string-lcci
 * Level : Easy
 */
public class Interview_106 {
    public static void main(String[] args) {
        System.out.println(compressString("aabbvvv"));
    }
    public static String compressString(String s) {
        if(s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int count = 1;
        char pre = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] != pre){
                sb.append(pre).append(count);
                pre = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(chars[s.length()-1]).append(count);
        if(sb.length() >= s.length()) return s;
        return sb.toString();
    }

}
