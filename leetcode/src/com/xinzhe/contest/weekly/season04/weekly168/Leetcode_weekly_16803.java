package com.xinzhe.contest.weekly.season04.weekly168;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/6/01
 * Title : 1297. 子串的最大出现次数
 * Description : 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 * link : https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring
 * Level : Medium
 * Comment 168周赛03
 */

public class Leetcode_weekly_16803 {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();
        char[] arr = s.toCharArray();
        while (right < n) {
            if (right - left < minSize) {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                if (map.size() <= maxLetters && right - left >= minSize - 1) {
                    res.put(s.substring(left, right + 1), res.getOrDefault(s.substring(left, right + 1), 0) + 1);
                }
                right++;
            }
            while (map.size() > maxLetters || right - left >= minSize) {
                int tmp = map.get(arr[left]);
                if (tmp > 1) {
                    map.put(arr[left], tmp - 1);
                } else if (tmp == 1) {
                    map.remove(arr[left]);
                }
                left++;
                if (map.size() <= maxLetters && right - left > minSize - 1 && right - left < maxSize) {
                    res.put(s.substring(left, right), res.getOrDefault(s.substring(left, right), 0) + 1);
                }
            }
        }
        System.out.println(Collections.unmodifiableMap(res));
        return res.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).map(Map.Entry::getValue).findFirst().orElse(0);
    }

}
