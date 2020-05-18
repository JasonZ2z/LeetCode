package com.xinzhe.contest.weekly.weekly185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/4/19 10:24
 * Title : 1417. 重新格式化字符串
 * Description : 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *              请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *              请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * link : https://leetcode-cn.com/problems/reformat-the-string
 * Level : Easy
 * Comment : 185周赛01
 */
public class Leetcode_weekly_18501 {
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("leetcode"));
        System.out.println(reformat("1229857369"));
        System.out.println(reformat("covid2019"));
        System.out.println(reformat("ab123"));
    }
    public static String reformat(String s) {
        int n = s.length();
        if(n == 1) return "";
        Map<Integer, Character> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if(Character.isDigit(s.charAt(i))){
                list.add(s.charAt(i));
            } else {
                map.put(i, s.charAt(i));
            }
        }
        int count1 = map.size();
        int count2 = list.size();

        if(count1 == count2){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for (int i = 0; i < n; ++i) {
                if(Character.isLetter(s.charAt(i))){
                    sb.append(s.charAt(i)).append(list.get(j++));
                }
            }
            return sb.toString();
        } else if(count1 == count2 + 1){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for (int i = 0; i < n; ++i) {
                if(Character.isLetter(s.charAt(i))){
                    sb.append(s.charAt(i));
                    if (j<count2){
                        sb.append(list.get(j++));
                    }
                }
            }
            return sb.toString();
        } else if(count1 == count2 - 1){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            sb.append(list.get(j++));
            for (int i = 0; i < n; ++i) {
                if(Character.isLetter(s.charAt(i))){
                    sb.append(s.charAt(i)).append(list.get(j++));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

}
