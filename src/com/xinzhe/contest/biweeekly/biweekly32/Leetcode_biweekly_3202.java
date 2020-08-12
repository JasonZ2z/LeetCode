package com.xinzhe.contest.biweeekly.biweekly32;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/8
 * Title : 1540. K 次操作转变字符串
 * Description : 给你两个字符串 s 和 t ，你的目标是在 k 次操作以内把字符串 s 转变成 t 。在第 i 次操作时（1 <= i <= k），你可以选择进行如下操作：
 *              选择字符串 s 中满足 1 <= j <= s.length 且之前未被选过的任意下标 j （下标从 1 开始），并将此位置的字符切换 i 次。不进行任何操作。
 *              切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z' 切换后会变成 'a'）。 请记住任意一个下标 j 最多只能被操作 1 次。
 *              如果在不超过 k 次操作内可以把字符串 s 转变成 t ，那么请你返回 true ，否则请你返回 false 。
 * link : https://leetcode-cn.com/problems/can-convert-string-in-k-moves
 * Level : Medium
 */
public class Leetcode_biweekly_3202 {
    public static void main(String[] args) {
        Leetcode_biweekly_3202 lc = new Leetcode_biweekly_3202();
        String s = "input";
        String t = "ouput";
        System.out.println(lc.canConvertString(s, t, 35));
    }

    public boolean canConvertString(String s, String t, int k) {
        int m = s.length();
        int n = t.length();
        if(m != n) return false;
        int sum  = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            int tmp = t.charAt(i) - s.charAt(i);
            if(tmp < 0) tmp += 26;
            if(tmp == 0) continue;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            sum = Math.max(sum, key + (value-1) * 26);
            if(sum > k) return false;
        }
        return true;
    }
}
