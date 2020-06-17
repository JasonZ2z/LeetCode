package com.xinzhe.contest.weekly.season04.weekly189;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title : 1451. 重新排列句子中的单词
 * Description : 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
 * 句子的首字母大写
 * text 中的每个单词都用单个空格分隔。
 * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 * 请同样按上述格式返回新的句子。
 * link : https://leetcode-cn.com/problems/rearrange-words-in-a-sentence
 * Level : Medium
 */
public class Leetcode_weekly_18902 {
    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool"));
    }

    public static String arrangeWords(String text) {
        List<Data> list = new ArrayList<>();

        String[] split = text.toLowerCase().split(" ");
        for (int i = 0; i < split.length; i++) {
            list.add(new Data(split[i], i));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Data data : list) {
            sb.append(data.s).append(" ");
        }
        String str = sb.toString().trim();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    static class Data implements Comparable<Data> {
        String s;
        int index;

        public Data(String s, int index) {
            this.s = s;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            if (s.length() == o.s.length()) {
                return index - o.index;
            }
            return s.length() - o.s.length();
        }
    }
}
