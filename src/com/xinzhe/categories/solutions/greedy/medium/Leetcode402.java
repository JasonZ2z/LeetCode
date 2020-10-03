package com.xinzhe.categories.solutions.greedy.medium;

import java.util.ArrayDeque;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 402. 移掉K位数字
 * Description : 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *              num 的长度小于 10002 且 ≥ k。num 不会包含任何前导零。
 * link : https://leetcode-cn.com/problems/remove-k-digits
 * Level : Medium
 */
//todo need to review
public class Leetcode402 {
    public static void main(String[] args) {
        Leetcode402 lc = new Leetcode402();
        System.out.println(lc.removeKdigits("1234567890", 9));
    }
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); ++i) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }
        if(stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() != 1 && sb.lastIndexOf("0") == sb.length()-1) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}
