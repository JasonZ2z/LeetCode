package com.xinzhe.contest.weekly.season03.weekly126;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1003. 检查替换后的词是否有效
 * Description : 给定有效字符串 "abc"。对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
 *              例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 *              如果给定字符串 S 有效，则返回 true；否则，返回 false。
 * link : https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 * Level : Medium
 */

public class Leetcode_weekly_12602 {
    public static void main(String[] args) {
        Leetcode_weekly_12602 lc = new Leetcode_weekly_12602();
        int[] arr = {2,-3,-1,5,-4};
    }
    public boolean isValid(String s) {
        int n = s.length();
        if(n <= 2) return false;
        if(!s.startsWith("a")) return false;
        if(!s.endsWith("c")) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == 'c') {
                if(stack.size() < 2 || stack.pop() != 'b' || stack.pop() != 'a') return false;
            }else {
                stack.push(c);
            }
        }
        return true;
    }
}
