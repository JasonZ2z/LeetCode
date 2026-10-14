package com.xinzhe.order.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/3/12 16:14
 * Title : 76. 最小覆盖子串
 * Description : 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * link : https://leetcode-cn.com/problems/minimum-window-substring/
 * Level : Hard
 */
public class Leetcode076 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n == 0 || n > m) return "";
        // 仅支持 ASCII（本题为大小写英文字母）
        int[] target = new int[128];
        for (int i = 0; i < n; i++) target[t.charAt(i)]++;
        int miss = 0;
        for (int c : target) {
            if (c > 0) miss++;
        }
        int left = 0, minLen = Integer.MAX_VALUE, bestStart = 0;
        for (int right = 0; right < m; right++) {
            if (--target[s.charAt(right)] == 0) miss--;
            while (miss == 0) {
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    bestStart = left;
                }
                if (++target[s.charAt(left)] > 0) miss++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + minLen);
    }
}
