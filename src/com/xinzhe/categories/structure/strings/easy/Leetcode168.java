package com.xinzhe.categories.structure.strings.easy;

/**
 * @Author Xin
 * @create 2020/6/24
 * Title : 168. Excel表列名称
 * Description : 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * link : https://leetcode-cn.com/problems/excel-sheet-column-title/
 * Level : Easy
 */
public class Leetcode168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(700));
    }
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            int a = n % 26;
            n = n /26;
            sb.append((char)('A' + a));
        }
        return sb.reverse().toString();
    }
}
