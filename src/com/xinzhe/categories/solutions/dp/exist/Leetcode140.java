package com.xinzhe.categories.solutions.dp.exist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/7/31
 * Title : 140. 单词拆分 II
 * Description : 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *              分隔时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 * link : https://leetcode-cn.com/problems/word-break-ii
 * Level : Hard
 * tag : 记忆化回溯
 */

// todo need to review
public class Leetcode140 {
    public static void main(String[] args) {
        String s= "catsanddog";
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        Leetcode140 lc = new Leetcode140();
        System.out.println(lc.wordBreak(s, list));
    }

    int max;
    HashSet<String> set = new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.max = 0;
        for(String word : wordDict) {
            set.add(word);
            max = Math.max(max, word.length());
        }
        return dfs(s, 0);
    }
    Map<Integer, List<String>> map = new HashMap<>();
    private List<String> dfs(String s, int index) {
        if(map.containsKey(index)) return map.get(index);
        List<String> res = new ArrayList<>();
        if(index == s.length()) {
            res.add("");
            return res;
        }
        for(int i=1; i + index <= s.length() && i <= max; i++) {
            String tmp = s.substring(index, i + index);
            if(set.contains(tmp)) {
                List<String> sub = dfs(s, i + index);
                for(String str : sub) {
                    res.add((tmp + " " + str).trim());
                }
            }
        }
        map.put(index, res);
        return res;
    }
}
