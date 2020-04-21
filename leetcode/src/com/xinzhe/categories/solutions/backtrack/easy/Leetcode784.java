package com.xinzhe.categories.solutions.backtrack.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/5 18:55
 * Title : 784. 字母大小写全排列
 * Description : 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * link : https://leetcode-cn.com/problems/letter-case-permutation/
 * Level : Easy
 */
public class Leetcode784 {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    static List<String> result = new ArrayList<>();
    public static List<String> letterCasePermutation(String S) {
        traceback(S.toCharArray(), 0);
        return result;
    }

    private static void traceback(char[] s, int start) {
        if(start == s.length){
            result.add(new String(s));
            return;
        }
        traceback(s, start+1);
        char c = s[start];
        if(Character.isLetter(c)){
            if(Character.isLowerCase(c)){
                s[start] = Character.toUpperCase(c);
            } else{
                s[start] = Character.toLowerCase(c);
            }
            traceback(s, start+1);

        }

    }

}
