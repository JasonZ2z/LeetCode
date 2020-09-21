package com.xinzhe.contest.weekly.season05.weekly207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Xin
 * @date 2020/9/20
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20701 {
    public static void main(String[] args) {
        Leetcode_weekly_20701 lc = new Leetcode_weekly_20701();
        String s = "  hello";
        System.out.println(lc.reorderSpaces(s));
    }

    public String reorderSpaces(String text) {
        int n = text.length();
        int count = 0;
        int j = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(text.charAt(i) == ' ') {
                if(i > 0 && text.charAt(i-1) != ' ') {
                    list.add(text.substring(j, i));
                }
                count++;
            } else {
                if(i > 0 && text.charAt(i-1) == ' ') {
                    j = i;
                }
            }
            if(i == n-1 && text.charAt(i) != ' ') {
                list.add(text.substring(j, n));
            }
        }

        if(count == 0) return text;
        if(list.size() == 1){
            return list.get(0) + " ".repeat(count);
        }
        int x = count / (list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i < list.size() - 1) {
                sb.append(" ".repeat(Math.max(0, x)));
            }
        }
        sb.append(" ".repeat(Math.max(0, n - sb.length())));
        return sb.toString();
    }
}
