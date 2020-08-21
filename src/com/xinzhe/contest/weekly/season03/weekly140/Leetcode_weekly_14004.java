package com.xinzhe.contest.weekly.season03.weekly140;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 1081. 不同字符的最小子序列
 * Description : 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * link : https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * Level : Medium
 * Comment : same as 316
 */

public class Leetcode_weekly_14004 {
    public static void main(String[] args) {
        Leetcode_weekly_14004 lc = new Leetcode_weekly_14004();
        System.out.println(lc.smallestSubsequence("bdaccdbddc"));
    }
    public String smallestSubsequence(String text) {
        Map<Character, Integer> map =new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = text.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : arr) {
            if(stack.contains(ch)) {
                map.put(ch, map.get(ch) -1);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) > 1) {
                char c = stack.pop();
                map.put(c, map.get(c) -1);
            }
            stack.push(ch);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
