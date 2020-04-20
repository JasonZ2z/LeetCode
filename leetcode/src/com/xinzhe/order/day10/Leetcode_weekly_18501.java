package com.xinzhe.order.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/4/19 10:24
 * Title :
 * Description :
 * link :
 * Level :
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
