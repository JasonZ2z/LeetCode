package com.xinzhe.categories.solutions.dp.exist;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/7/31
 * Title : 140. 单词拆分 II
 * Description : 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *              分隔时可以重复使用字典中的单词。
 *              你可以假设字典中没有重复的单词。
 * link : https://leetcode-cn.com/problems/word-break-ii
 * Level : Hard
 * tag : 记忆化回溯
 */

// todo need to review
public class Leetcode140 {
    public static void main(String[] args) {
        String s= "c";
        List<String> list = Arrays.asList("c,", "d");
        //System.out.println(wordBreak(s, list));
    }
    int max = 0;
    HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.max = wordDict.stream().max(Comparator.comparingInt(String::length)).get().length();
        return dfs(s, wordDict, 0);

    }

    private List<String> dfs(String s, List<String> wordDict, int i) {
        if(map.containsKey(i)) return map.get(i);
        List<String> res = new ArrayList<>();
        if(i == s.length()) {
            res.add("");
        }
        for (int j = 0; j <= s.length() && j <= max; ++j) {
            if(wordDict.contains(s.substring(i, j))) {
                List<String> list = dfs(s, wordDict, j);
                for (String l : list) {
                    res.add((s.substring(i,j) + " " + l).trim());
                }
            }
        }
        map.put(i, res);
        return res;
    }
}
