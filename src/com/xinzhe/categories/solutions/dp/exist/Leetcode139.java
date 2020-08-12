package com.xinzhe.categories.solutions.dp.exist;

import java.util.Arrays;
import java.util.List;

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
        String s= "c";
        List<String> list = Arrays.asList("c,", "d");
        System.out.println(wordBreak(s, list));
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
}
