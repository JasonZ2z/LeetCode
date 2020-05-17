package com.xinzhe.contest.weekly.weekly179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_17902 {
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
