package com.xinzhe.contest.weekly.season03.weekly137;

import java.util.ArrayDeque;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1047. 删除字符串中的所有相邻重复项
 * Description : 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *              在 S 上反复执行重复项删除操作，直到无法继续删除。在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * link : https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * Level : Easy
 */

public class Leetcode_weekly_13702 {
    public static void main(String[] args) {
        Leetcode_weekly_13702 lc = new Leetcode_weekly_13702();
    }

    public String removeDuplicates(String s) {
        int n = s.length();
        if(n == 1) return s;
        char[] arr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : arr) {
            if(stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
