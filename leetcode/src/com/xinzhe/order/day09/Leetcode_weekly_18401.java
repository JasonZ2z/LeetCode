package com.xinzhe.order.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/12 10:10
 * Title : 5380. 数组中的字符串匹配
 * Description : 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 *              如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * link : https://leetcode-cn.com/problems/string-matching-in-an-array
 * Level : Easy
 */
public class Leetcode_weekly_18401 {
    public static void main(String[] args) {
        String[] wrods = {"blue","green","bu"};
        System.out.println(stringMatching(wrods));
    }
    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < n-1; ++i) {
            String word = words[i];
            for (int j = i+1; j < n; ++j) {
                if(words[j].contains(word)){
                    list.add(word);
                    break;
                }
            }
        }
        return list;
    }
}
