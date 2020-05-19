package com.xinzhe.contest.weekly.weekly175;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/5/19
 * Title : 1347. 制造字母异位词的最小步骤数
 * Description : 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 * link : https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
 * Level : Medium
 * Comment 175周赛02
 */

public class Leetcode_weekly_17502 {
    public static void main(String[] args) {
        String s = "friend";
        String t = "family";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        Map<Character, Integer> smap = s.chars().boxed().collect(Collectors.toMap(k -> (char) k.intValue(), v -> 1, Integer::sum));
        Map<Character, Integer> tmap = t.chars().boxed().collect(Collectors.toMap(k -> (char) k.intValue(), v -> 1, Integer::sum));


        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (smap.containsKey(entry.getKey())) {
                int res = smap.get(entry.getKey()) - entry.getValue();
                if (res <= 0) {
                    smap.entrySet().removeIf(a -> a.getKey().equals(entry.getKey()));
                } else {
                    smap.put(entry.getKey(), res);
                }
            }
        }
        return smap.values().stream().mapToInt(Integer::intValue).sum();
    }

}
