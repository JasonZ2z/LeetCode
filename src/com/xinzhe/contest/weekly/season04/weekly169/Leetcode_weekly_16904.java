package com.xinzhe.contest.weekly.season04.weekly169;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/5/29
 * Title : 1307. 口算难题
 * Description : 给你一个方程，左边用 words 表示，右边用 result 表示。你需要根据以下规则检查方程是否可解：
 *              每个字符都会被解码成一位数字（0 - 9）。
 *              每对不同的字符必须映射到不同的数字。
 *              每个 words[i] 和 result 都会被解码成一个没有前导零的数字。
 *              左侧数字之和（words）等于右侧数字（result）。 
 *              如果方程可解，返回 True，否则返回 False
 * link : https://leetcode-cn.com/problems/verbal-arithmetic-puzzle
 * Level : Hard
 * Comment 169周赛04
 */
// todo : too hard to understand
public class Leetcode_weekly_16904 {

    private String[] words;
    private String result;
    private List<Character> charList;
    private int charSize;
    private Set<Character> nonZeroSet;

    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        int len = result.length();
        Set<Character> set = new HashSet<>();
        nonZeroSet = new HashSet<>();

        for (String word : words) {
            if (word.length() > len) return false;
            nonZeroSet.add(word.charAt(0));
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }
        nonZeroSet.add(result.charAt(0));

        for (char c : result.toCharArray()) {
            set.add(c);
        }

        charList = new ArrayList<>(set);
        charSize = charList.size();

        int[] map = new int[26];
        Arrays.fill(map, -1);
        return backTrack(0, new boolean[10], map);

    }

    private boolean backTrack(int from, boolean[] visited, int[] map) {
        if (from == charSize) return isMath(map);
        char cur = charList.get(from);
        for (int i = 0; i <= 9; ++i) {
            if (i == 0 && nonZeroSet.contains(cur) || visited[i]) continue;
            visited[i] = true;
            map[cur - 'A'] = i;
            boolean isMath = backTrack(from + 1, visited, map);
            if (isMath) return true;
            map[cur - 'A'] = -1;
            visited[i] = false;
        }
        return false;
    }

    private boolean isMath(int[] map) {
        int sum = 0;
        for (String word : words) {
            int tmp = 0;
            for (char c : word.toCharArray()) {
                tmp *= 10;
                tmp += map[c - 'A'];
            }
            sum += tmp;
        }
        int value = 0;
        for (char c : result.toCharArray()) {
            value *= 10;
            value += map[c - 'A'];
        }
        return sum == value;

    }
}
