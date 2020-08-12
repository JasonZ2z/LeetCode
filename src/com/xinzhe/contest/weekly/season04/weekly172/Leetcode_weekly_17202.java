package com.xinzhe.contest.weekly.season04.weekly172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Xin
 * @date 2020/5/23
 * Title : 1324. 竖直打印单词
 * Description : 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 *          单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 *          每个单词只能放在一列上，每一列中也只能有一个单词。
 * link : https://leetcode-cn.com/problems/print-words-vertically
 * Level : Medium
 * Comment 172周赛02
 */

public class Leetcode_weekly_17202 {
    public static void main(String[] args) {
        String s = "TO BE OR NOT TO BE";
        System.out.println(printVertically(s));
    }

    public static List<String> printVertically(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add(s);
            return res;
        }

        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
        int max = Stream.of(arr).map(a -> a.length()).min((a, b) -> b - a).get();
        System.out.println(max);
        for (int i = 0; i < max; ++i) {
            StringBuilder sb = new StringBuilder();
            for (String value : arr) {
                if (i < value.length()) {
                    sb.append(value.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            int j = sb.length() - 1;
            while (j >= 0) {
                if (sb.charAt(j) != ' ') {
                    break;
                }
                j--;
            }

            res.add(sb.substring(0, j + 1));
        }
        return res;
    }

}
