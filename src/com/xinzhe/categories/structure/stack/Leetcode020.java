package com.xinzhe.categories.structure.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/14
 * Title : 20. 有效的括号
 * Description : 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串。
 * link : https://leetcode-cn.com/problems/valid-parentheses
 * Level : Hard
 */
public class Leetcode020 {
    public boolean isValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int[] count = new int[3];
        List<Character> dict = Arrays.asList('(', ')', '{', '}', '[', ']');
        while(i < s.length()) {
            int j = dict.indexOf(s.charAt(i++));
            if((j&1)==0) {
                stack.push(j);
                count[j/2]++;
            } else {
                if(stack.isEmpty() || count[j/2] == 0 || stack.peek() != j-1) return false;
                else {
                    count[j/2]--;
                    stack.pop();
                }
            }
        }
        return Arrays.stream(count).noneMatch(a -> a > 0);
    }
}
