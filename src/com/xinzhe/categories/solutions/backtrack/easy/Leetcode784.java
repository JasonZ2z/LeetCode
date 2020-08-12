package com.xinzhe.categories.solutions.backtrack.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/5 18:55
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
        traceBack(S.toCharArray(), 0);
        return result;
    }

    private static void traceBack(char[] s, int start) {
        if(start == s.length){
            result.add(new String(s));
            return;
        }
        traceBack(s, start+1);
        char c = s[start];
        if(Character.isLetter(c)){
            if(Character.isLowerCase(c)){
                s[start] = Character.toUpperCase(c);
            } else{
                s[start] = Character.toLowerCase(c);
            }
            traceBack(s, start+1);
        }
    }

    //todo need to review
    //二分掩码
    //根据位掩码，构造正确的全排列结果。如果下一个字符是字母，则根据位掩码添加小写或大写字母。 否则添加对应的数字。
    public static List<String> letterCasePermutation2(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(Character.isLetter(c)) count++;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << count; ++i) {
            int b = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if(Character.isLetter(c)) {
                    if(((i >> b++) & 1) == 1) {
                        sb.append(Character.toLowerCase(c));
                    } else {
                        sb.append(Character.toUpperCase(c));
                    }
                } else {
                    sb.append(c);
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
