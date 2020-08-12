package com.xinzhe.categories.solutions.towpointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @date 2020/4/10 21:37
 * Title : 151. 翻转字符串里的单词
 * Description : 给定一个字符串，逐个翻转字符串中的每个单词。
 *              无空格字符构成一个单词。
 *              输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *              如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * link : https://leetcode-cn.com/problems/reverse-words-in-a-string
 * Level : Medium
 */

public class Leetcode151 {
    //输入: "the sky is blue"
    //       eulb si yks eht
    //输出: "blue is sky the"

    //输入: "  hello world!  "
    //输出: "world! hello"

    //输入: "a good   example"
    //输出: "example good a"
    public static void main(String[] args) {
        String s = "a      b";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
        System.out.println(reverseWords3(s));
    }
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String s1 = s.trim();
        if(s1.length() == 0) return "";
        StringBuilder sb = new StringBuilder(s1);
        s= sb.reverse().toString().trim();
        StringBuilder res = new StringBuilder();
        int i = 0, j;
        while (i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
            } else {
                j = i;
                while (i < s.length() && s.charAt(i) != ' '){
                    i++;
                }
                res.append(new StringBuilder(s.substring(j, i)).reverse().toString()).append(" ");
            }
        }
        return res.substring(0, res.length()-1);
    }

    public static String reverseWords2(String s){
        s = s.trim();
        String[] s1 = s.split("\\s+");
        List<String> strings = Arrays.asList(s1);
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

    public static String reverseWords3(String s) {
        String[] ss = s.split(" ");
        int n = ss.length;
        StringBuilder ans = new StringBuilder();
        for (int i = n - 1;i >= 0;i--){
            if (ss[i].length() == 0) continue;
            ans.append(ss[i]).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
