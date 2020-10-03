package com.xinzhe.order.day13;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/5/7
 * Title : 1021. 删除最外层的括号
 * Description : 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * link : https://leetcode-cn.com/problems/remove-outermost-parentheses
 * Level : Easy
 */
public class Leetcode1021 {
    public static String removeOuterParentheses(String s) {
        int n = s.length();
        if(n < 2) return "";
        LinkedList<Character> queue = new LinkedList<>();
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                queue.add(s.charAt(i));
                left++;
            }else{
                queue.add(s.charAt(i));
                right++;
            }
            if(left == right && left != 0){
                queue.removeFirst();
                queue.removeLast();
                while (queue.size() > 0) {
                    sb.append(queue.removeFirst());
                }
                left=0;
                right=0;
            }
        }
        return sb.toString();
    }
}
