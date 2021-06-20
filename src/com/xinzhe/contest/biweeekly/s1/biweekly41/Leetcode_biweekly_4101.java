package com.xinzhe.contest.biweeekly.s1.biweekly41;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/12/12
 * Title : 1684. 统计一致字符串的数目
 * Description : 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串。请你返回words数组中一致字符串的数目。
 * link : https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 * Level : Easy
 */
public class Leetcode_biweekly_4101 {
    public static void main(String[] args) {
        Leetcode_biweekly_4101 lc = new Leetcode_biweekly_4101();
        int[] arr = {2, 4, 9, 3};
        System.out.println("abc".repeat(0));
    }
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(char c :allowed.toCharArray()) set.add(c);
        for(String s : words){
            for(char c :s.toCharArray()){
                if(!set.contains(c)) {
                    ans++;
                    break;
                }
            }
        }
        return words.length - ans;
    }
}