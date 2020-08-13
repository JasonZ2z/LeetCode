package com.xinzhe.contest.nowcoder.s1.s111;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/8/13
 * Title :
 * Description :
 * link :
 */
public class nowcoder_1101 {
    public static void main(String[] args) {
        nowcoder_1101 nv = new nowcoder_1101();
        System.out.println(nv.solve("00110001"));
    }
    public String solve (String str) {
        // write code here
        int n = str.length();

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < n){
            //(((c - '0') ^ (stack.peek() - '0'))==1
            char c = str.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            }else if(stack.peek() == '0'){
                if(c == '0') {
                    stack.pop();
                    if(stack.size() > 0 && stack.peek() == '1') {
                        stack.pop();
                    }else {
                        stack.push('1');
                    }
                }else {
                    stack.push(c);
                }
            }else {
                if(c == '1') {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
