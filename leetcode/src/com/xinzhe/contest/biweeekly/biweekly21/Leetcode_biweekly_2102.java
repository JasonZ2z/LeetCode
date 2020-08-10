package com.xinzhe.contest.biweeekly.biweekly21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/5/14
 * Title : 1371. 每个元音包含偶数次的最长子字符串
 * Description : 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * link : https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * Level : Medium
 * Comment 21双周赛02
 * tag : 前缀和， 压缩状态
 */

public class Leetcode_biweekly_2102 {
    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        System.out.println(findTheLongestSubstring2(s));
    }

    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int key = 0;
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        // <status, index>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (list.contains(c)) {
                key ^= (1 << list.indexOf(c));
            }
            if (map.containsKey(key)) {
                res = Math.max(res, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return res;
    }

    public static int findTheLongestSubstring2(String s) {
        int[] status = new int[1 << 5];
        int res = 0;
        int pos = 0;
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Arrays.fill(status, -1);
        status[0] = 0;
        for (int i = 0; i < s.length(); ++i) {
            int index = list.indexOf(s.charAt(i));
            if (index >= 0) {
                pos ^= (1 << index);
            }
            if (status[pos] >= 0) {
                res = Math.max(res, i + 1 - status[pos]);
            } else {
                status[pos] = i + 1;
            }
        }
        return res;
    }
}
