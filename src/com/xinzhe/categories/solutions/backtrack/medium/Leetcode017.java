package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/21
 * Title : 17. 电话号码的字母组合
 * Description : 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * link : https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Level : Medium
 */

public class Leetcode017 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    static List<String> res= new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        List<List<Character>> dict = new ArrayList<>();
        dict.add(Arrays.asList('a','b','c'));
        dict.add(Arrays.asList('d','e','f'));
        dict.add(Arrays.asList('g','h','i'));
        dict.add(Arrays.asList('j','k','l'));
        dict.add(Arrays.asList('m','n','o'));
        dict.add(Arrays.asList('p','q','r', 's'));
        dict.add(Arrays.asList('t','u','v'));
        dict.add(Arrays.asList('w','x','y', 'z'));

        bfs(digits, dict, 0, "");
        return res;

    }

    private static void bfs(String digits, List<List<Character>> dict, int index, String s) {
        if(s.length() == digits.length()) {
            res.add(s);
            return;
        }
        if(index > digits.length()) return;
        int i = Integer.parseInt(String.valueOf(digits.charAt(index)));
        for (Character character : dict.get(i-2)) {
            bfs(digits, dict, index+1, s+character);
        }
    }
}
