package com.xinzhe.top100.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/2/29 18:01
 * Title : 3. 无重复字符的最长子串
 * Description : 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * link : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Leetcode003 {
    public static void main(String[] args) {
        String s = "abcbda";
        //System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
        //System.out.println(lengthOfLongestSubstring3(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    if(j == s.length()-1){
                        return Math.max(result, set.size());
                    }
                } else {
                    result = Math.max(result, set.size());
                    break;
                }
            }

        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i=0,j=0;
        int result = 0;
        while(i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result = Math.max(result, set.size());
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            map.put(s.charAt(j), j+1);

            result = Math.max(result, j-i+1);
        }
        return result;
    }
}
