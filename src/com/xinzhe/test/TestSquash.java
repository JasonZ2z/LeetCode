package com.xinzhe.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xzheng
 * @create 2021/2/25
 */
public class TestSquash {
    public static void main(String[] args) {
        String s = "ababacb";
        TestSquash ts = new TestSquash();
        System.out.println(ts.longestSubstring(s, 3));
    }

    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        if(k == 1) return s.length();
        if(s.length() < k) return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if(map.get(c) < k) {
                int ans = 0;
                for (String cur : s.split(c + "")) {
                    ans = Math.max(ans, longestSubstring(cur, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}
