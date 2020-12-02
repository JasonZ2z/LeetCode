package com.xinzhe.categories.structure.stack.monotonicStack;

import java.util.ArrayDeque;

/**
 * @author Xin
 * @date 2020/3/12 19:54
 * Title : 1081. 不同字符的最小子序列
 * Description : 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * link : https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * Level : Medium
 */
//todo
public class Leetcode1081 {
    public static void main(String[] args) {
        Leetcode1081 lc = new Leetcode1081();
        System.out.println(lc.smallestSubsequence("ecbacba"));
    }
    public String smallestSubsequence(String text) {
        int n = text.length();
        if(n == 1) return text;
        int[] cnt = new int[26];
        char[] arr = text.toCharArray();

        for(char c : arr) {
            cnt[c-'a']++;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : arr) {
            if(stack.contains(c)){
                cnt[c-'a']--;
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && cnt[stack.peek()-'a'] > 1){
                cnt[stack.pop()-'a']--;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
