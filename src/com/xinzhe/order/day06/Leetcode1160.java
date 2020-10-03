package com.xinzhe.order.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/3/17 18:01
 * Title : 1160. 拼写单词
 * Description : 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *              假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *              注意：每次拼写时，chars 中的每个字母都只能用一次。
 *              返回词汇表 words 中你掌握的所有单词的 长度之和。
 * link : https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * Level : Easy
 */

public class Leetcode1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
    public int countCharacters2(String[] words, String chars) {
        int[] c = new int[26];
        for(char cc : chars.toCharArray()) {
            c[cc - 'a'] += 1;
        }
        int res = 0;
        a: for(String word : words) {
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[ww - 'a'] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }


    public static int countCharacters(String[] words, String chars) {
        if(words == null || words.length == 0 || chars == null || "".equals(chars)) return 0;
        int n = chars.length();
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            char c = chars.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (String word : words) {
            Map<Character, Integer> tmp = new HashMap<>(word.length());
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                tmp.put(c, tmp.getOrDefault(c, 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : tmp.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (!map.containsKey(key) || map.get(key) < value) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                sum += word.length();
            }

        }
        return sum;
    }
}
