package com.xinzhe.order.day05;

import java.util.HashMap;

/**
 * @Author Xin
 * @create 2020/3/12 19:54
 * Title : 1081. 不同字符的最小子序列
 * Description : 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * link : https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 * Level : Medium
 */
//todo
public class Leetcode1081 {
    public String smallestSubsequence(String text) {
        // null
        //hashmap count
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        return "";
    }
}
