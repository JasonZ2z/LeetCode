package com.xinzhe.categories.structure.strings.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/12/07
 * Title : 720. 词典中最长的单词
 * Description : 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。 若无答案，则返回空字符串。
 * link : https://leetcode-cn.com/problems/longest-word-in-dictionary
 * Level : Easy
 */
public class Leetcode720 {
    public static void main(String[] args) {
        Leetcode720 lc = new Leetcode720();
        String[] s  = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(lc.longestWord(s));
    }
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i < word.length(); ++i) {
                if (!set.contains(word.substring(0, word.length() - i))) {
                    flag = false;
                    break;
                }
            }
            if(flag) return word;
        }
        return "";
    }
}
