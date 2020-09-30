package com.xinzhe.categories.solutions.dp.exist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/3/17 18:51
 * Title : 139. 单词拆分
 * Description : 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *          说明：
 *              拆分时可以重复使用字典中的单词。
 *              你可以假设字典中没有重复的单词。
 * link : https://leetcode-cn.com/problems/word-break
 * Level : Medium
 */
public class Leetcode139 {
    public static void main(String[] args) {
//        String s= "aaaaaaa";
//        List<String> list = Arrays.asList("aaaa", "aaa");
        String s= "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, list));
        Leetcode139 lc = new Leetcode139();
        System.out.println(lc.wordBreak2(s, list));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0) return false;
        if(wordDict.size() == 1) return s.equals(wordDict.get(0));

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for(int j = i-1; j >= 0; --j) {
                String tmp = s.substring(j, i);
                if (wordDict.contains(tmp) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    HashSet<String> set;
    String s;
    Map<Integer, Boolean> map = new HashMap<>();
    public boolean wordBreak2(String s, List<String> wordDict) {
        this.s = s;
        this.set = new HashSet<>(wordDict);
        return dfs(0);
    }
    private boolean dfs(int index) {
        if(index == s.length()) return false;
        if(map.containsKey(index)) return map.get(index);
        boolean flag = false;
        for (int i = index; i < s.length(); ++i) {
            String tmp = s.substring(index, i + 1);
            if(set.contains(tmp)) {
                if(i + 1 == s.length() || dfs(i+1)) {
                    flag = true;
                    break;
                }
            }
        }
        map.put(index, flag);
        return flag;
    }
}
