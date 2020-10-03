package com.xinzhe.contest.weekly.season04.weekly152;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 1178. 猜字谜
 * Description : 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *              单词 word 中包含谜面 puzzle 的第一个字母。
 *              单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 *              返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 * link : https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_15204 {
    public static void main(String[] args) {
        Leetcode_weekly_15204 lc = new Leetcode_weekly_15204();
        String[] a1 = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] a2 = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(lc.findNumOfValidWords(a1, a2));
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        for (String puzzle : puzzles) {
            int count= 0;
            for (int i = 1 << 6; i < 1 << 7; ++i) {
                int mask = 0;
                for (int j = 0; j < puzzle.length(); j++) {
                    if((i & (1 << (6 - j))) != 0) {
                        mask |= 1 << (puzzle.charAt(j) - 'a');
                    }
                }
                count += map.getOrDefault(mask, 0);
            }
            res.add(count);
        }
        return res;
    }
}
