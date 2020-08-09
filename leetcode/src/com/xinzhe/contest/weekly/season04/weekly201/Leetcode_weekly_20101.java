package com.xinzhe.contest.weekly.season04.weekly201;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title : 1534. 统计好三元组
 * Description : 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *          0 <= i < j < k < arr.length
 *          |arr[i] - arr[j]| <= a
 *          |arr[j] - arr[k]| <= b
 *          |arr[i] - arr[k]| <= c
 *          其中 |x| 表示 x 的绝对值。返回 好三元组的数量 。
 * link : https://leetcode-cn.com/problems/count-good-triplets
 * Level : Easy
 */
public class Leetcode_weekly_20101 {
    public static void main(String[] args) {
        Leetcode_weekly_20101 lc = new Leetcode_weekly_20101();
        System.out.println(lc.makeGood("leEeetcode"));
    }
    public String makeGood(String s) {


        int n = s.length();
        if(n == 1) return s;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < n) {
            if(!stack.isEmpty() && (stack.peek() != arr[i] && Character.toLowerCase(stack.peek()) == Character.toLowerCase(arr[i])) ){
                stack.pop();
            }else {
                stack.push(arr[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
