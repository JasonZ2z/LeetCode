package com.xinzhe.contest.weekly.season03.weekly137;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1048. 最长字符串链
 * Description : 给出一个单词列表，其中每个单词都由小写英文字母组成。
 *              如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。
 *              词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。
 *              从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
 * link : https://leetcode-cn.com/problems/longest-string-chain
 * Level : Medium
 */

//tips : 单词字母之间有顺序要求
public class Leetcode_weekly_13703 {
    public static void main(String[] args) {
        Leetcode_weekly_13703 lc = new Leetcode_weekly_13703();
        //String[] w = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        String[] w = {"a","b","ba","bca","bda","bdca"};
        System.out.println(lc.longestStrChain(w));
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        if(n == 1) return 1;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int max = 1;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String pre = word.substring(0, i) + word.substring(i+1);
                best = Math.max(best, dp.getOrDefault(pre,0) + 1);
            }
            dp.put(word, best);
            max = Math.max(max, best);
        }
        return max;
    }
}
