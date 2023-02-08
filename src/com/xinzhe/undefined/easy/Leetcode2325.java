package com.xinzhe.undefined.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2023/02/01
 * Title : 2325. 解密消息
 * link : https://leetcode.cn/problems/decode-the-message/
 * Level : Easy
 */
public class Leetcode2325 {
    public String decodeMessage(String key, String message) {
        int[] c = new int[26];
        Set<Character> set = new HashSet<>();
        int i = 0;
        for (char x : key.toCharArray()) {
            if(x == ' ' || set.contains(x)) continue;
            set.add(x);
            c[x - 'a'] = i++;
        }
        StringBuilder sb = new StringBuilder();
        for (char y : message.toCharArray()) {
            if(y == ' ') sb.append(' ');
            else {
                sb.append((char) ('a' + c[y - 'a']));
            }
        }
        return sb.toString();
    }
}
