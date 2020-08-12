package com.xinzhe.categories.structure.strings.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/4/16
 * Title : 6. Z 字形变换
 * Description : 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * link : https://leetcode-cn.com/problems/zigzag-conversion/
 * Level : Medium
 */

public class Leetcode006 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING" , 4));
    }
    private static String convert(String s, int m) {
        int n = s.length();
        if(n < 2 || m < 2) return s;
        int count = 0;
        int i = 0;
        List<StringBuilder> list = new ArrayList<>(m);
        for (int k = 0; k < m; k++) {
            list.add(new StringBuilder());
        }
        while(count < n) {
            while(i < m && count < n){
                list.get(i).append(s.charAt(count++));
                i++;
            }
            i--;
            while(i > 0 && count < n) {
                list.get(i-1).append(s.charAt(count++));
                i--;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; ++j) {
            sb.append(list.get(j));
        }
        return sb.toString();
    }
}
