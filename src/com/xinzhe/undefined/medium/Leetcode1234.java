package com.xinzhe.undefined.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2023/02/13
 * Title : 1234. 替换子串得到平衡字符串
 * link : https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 * Level : Medium
 */
public class Leetcode1234 {
    public int balancedString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int[] arr = new int[4];
        int i = 0;
        for (Integer a : map.values()) {
            arr[i++] = a;
        }
        Arrays.sort(arr);
        int res = 0;
        for (int b : arr) {
            res += Math.abs(n/4  - b);
        }
        return res/2;
    }
}
