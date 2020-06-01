package com.xinzhe.contest.biweeekly.biweekly27;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/5/30
 * Title :
 * Description :
 * link :
 * Level : Hard
 */
//todo undo
public class Leetcode_biweekly_2704 {
    public static void main(String[] args) {
        String s = "aabcabcab";
        System.out.println(maxFreq(s, 2, 2, 3));
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = s.length();
        char[] arr = s.toCharArray();
        while (right < n) {
            if (right - left < maxSize) {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                if (map.size() <= maxLetters && right - left >= minSize - 1) {
                    res.put(s.substring(left, right + 1), res.getOrDefault(s.substring(left, right + 1), 0) + 1);
                }
                right++;
                while (map.size() > maxLetters || right - left >= maxSize) {
                    int tmp = map.get(arr[left]);
                    if (tmp > 1) map.put(arr[left], tmp - 1);
                    if (tmp == 1) {
                        map.remove(arr[left]);
                    }
                    if (map.size() <= maxLetters && right - left >= minSize - 1 && right - left < maxSize) {
                        res.put(s.substring(left, right), res.getOrDefault(s.substring(left, right), 0) + 1);
                    }
                    left++;
                }
            }
        }
        System.out.println(Collections.unmodifiableMap(res));
        return res.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).map(Map.Entry::getValue).findFirst().orElse(0);
    }

}
