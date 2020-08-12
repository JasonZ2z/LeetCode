package com.xinzhe.contest.weekly.season04.weekly162;

/**
 * @author Xin
 * @date 2020/6/17
 * Title : 1255. 得分最高的单词集合
 * Description : 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
 *              请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
 *      单词拼写游戏的规则概述如下：
 *          玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
 *          可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
 *          单词表 words 中每个单词只能计分（使用）一次。
 *          根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
 *          本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
 * link : https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters/
 * Level : Hard
 * Comment 162周赛04
 */
//todo need to review
public class Leetcode_weekly_16204 {
    int res = 0;
    String[] words;
    int[] score;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        int[] arr = new int[26];
        for (char c : letters) {
            arr[c - 'a']++;
        }
        dfs(0,0,arr);
        return res;
    }

    private void dfs(int index, int sum, int[] arr) {
        if(index >= words.length) return;
        int[] tmp = arr.clone();
        int tmpSum = 0;
        String str = words[index];
        for (char c : str.toCharArray()) {
            if(arr[c - 'a'] > 0) {
                tmpSum += score[c - 'a'];
                arr[c - 'a']--;
            } else {
                dfs(index+1, sum, tmp);
                return;
            }
        }
        res = Math.max(res, sum + tmpSum);
        dfs(index+1, sum + tmpSum, arr);
        dfs(index + 1, sum, tmp);
    }

    int getBit(int x, int y) {
        return (x >> y) & 1;
    }

    boolean ok(String word, int[] cnt) {
        for (int i = 0; i < word.length(); i++) {
            if(cnt[word.charAt(i) - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }

    public int maxScoreWords2(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        for (char c : letters) cnt[c - 'a']++;
        int n = words.length;
        int[] scores = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                scores[i] += score[words[i].charAt(j) - 'a'];
            }
        }
        int[] clone;
        int maxScore = 0, bound = (int)Math.pow(2,n);
        for (int i = 0; i <= bound; ++i) {
            clone = cnt.clone();
            int total = 0;
            for (int j = 0; j < n; ++j) {
                if(getBit(i,j) == 1) {
                    if(ok(words[j], clone)) {
                        total += scores[j];
                    } else {
                        break;
                    }
                }
            }
            maxScore = Math.max(maxScore, total);
        }
        return maxScore;
    }
}
