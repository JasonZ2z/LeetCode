package com.xinzhe.categories.dp.exist;

import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/17 18:51
 * Title : 139. 单词拆分
 * Description : 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *          说明：
 *              拆分时可以重复使用字典中的单词。
 *              你可以假设字典中没有重复的单词。
 * link : https://leetcode-cn.com/problems/word-break
 * Level : Medium
 */
public class Leetcode139 {
    List<String> wordDict;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(0);
    }

    private boolean dfs(int start) {
        if(start == s.length()) return true;

        for (int i = start+1; i <= s.length(); i++) {
            if(exist(start, i) && dfs(i)){
                return true;
            }
        }
        return false;
    }

    public boolean exist(int start, int end){
        if(start < end && end <= s.length()){
            String tmp = s.substring(start, end);
            return  wordDict.contains(tmp);
        }
        return false;
    }
}
