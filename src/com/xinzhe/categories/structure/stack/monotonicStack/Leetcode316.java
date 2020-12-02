package com.xinzhe.categories.structure.stack.monotonicStack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 316. 去除重复字母
 * Description : 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * link : https://leetcode-cn.com/problems/remove-duplicate-letters/
 * Level : Hard
 */
//todo need to review
public class Leetcode316 {
    public static void main(String[] args) {
        Leetcode316 lc = new Leetcode316();
        System.out.println(lc.removeDuplicateLetters("1234567890"));
    }
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if(stack.contains(c)) {
                map.put(c, map.get(c)-1);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 1){
                char ch = stack.pop();
                map.put(ch, map.get(ch)-1);
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
