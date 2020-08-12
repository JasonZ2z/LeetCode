package com.xinzhe.categories.structure.strings.kmp;

/**
 * @Author Xin
 * @create 2020/5/8
 * Title : 459. 重复的子字符串
 * Description : 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * link : https://leetcode-cn.com/problems/repeated-substring-pattern/
 * Level : Easy
 */
public class Leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] next = new int[n+1];
        next[0] = -1;
        int i=0, j=-1;
        while(i < n) {
            if(j == -1 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next[n] > 0 && n %(n-next[n]) == 0;
    }
}
