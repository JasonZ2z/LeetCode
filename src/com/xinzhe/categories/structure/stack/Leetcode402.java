package com.xinzhe.categories.structure.stack;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/11/15
 * Title : 402. 移掉K位数字
 * Description : 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *              num 的长度小于 10002 且≥ k。num 不会包含任何前导零。
 * link : https://leetcode-cn.com/problems/remove-k-digits
 * Level : Medium
 */
//todo need to review
public class Leetcode402 {
    public static void main(String[] args) {
        Leetcode402 lc = new Leetcode402();
        String num = "112";
        System.out.println(lc.removeKdigits(num, 1));

    }

    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n) return "0";
        Stack<Character> stack = new Stack<>();
        char[] arr = num.toCharArray();

        int i =0;
        while (i < n) {
            while (k > 0 && !stack.isEmpty() && arr[i] < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(arr[i++]);
        }
        StringBuilder sb = new StringBuilder();
        //handle case like "112", k = 1
        while (!stack.isEmpty() &&  k-- > 0) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        //// handle case like "0200"
        int x = 0;
        for (int j = 0; j < sb.length(); j++) {
            if(sb.charAt(j) != '0') break;
            x++;
        }
        String res = sb.substring(x);
        return "".equals(res) ? "0" : res;
    }

}
