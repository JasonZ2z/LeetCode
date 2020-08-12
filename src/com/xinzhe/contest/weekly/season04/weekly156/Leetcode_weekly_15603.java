package com.xinzhe.contest.weekly.season04.weekly156;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/7/17
 * Title : 1209. 删除字符串中的所有相邻重复项 II
 * Description : 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *              你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。在执行完所有删除操作后，返回最终得到的字符串。本题答案保证唯一。
 * link : https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 * Level : Medium
 * Comment 156周赛03
 */

public class Leetcode_weekly_15603 {

    public static void main(String[] args) {
        Leetcode_weekly_15603 lc = new Leetcode_weekly_15603();
        System.out.println(lc.removeDuplicates("deeedbbcccbdaa", 3));
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> count = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if(stack.isEmpty() || count.peek() < k) {
                if(!stack.isEmpty()) {
                    char c = stack.peek();
                    int pre = count.peek();
                    if(arr[i] == c) {
                        count.pop();
                        count.push(pre + 1);
                    } else {
                        count.push(1);
                    }

                } else {
                    count.push(1);
                }
                stack.push(arr[i]);
            }
            if(count.peek() == k) {
                int pop = count.pop();
                while (pop-- > 0) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
