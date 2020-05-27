package com.xinzhe.contest.biweeekly.biweekly17;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/5/26
 * Title : 1316. 不同的循环子字符串
 * Description : 给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：
 *              可以写成某个字符串与其自身相连接的形式（即，可以写为 a + a，其中 a 是某个字符串）。
 *              例如，abcabc 就是 abc 和它自身连接形成的。
 * link : https://leetcode-cn.com/problems/distinct-echo-substrings
 * Level : Hard
 * Comment 17双周赛04
 */

//todo need to review
public class Leetcode_biweekly_1704 {
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        int n = text.length();
        char[] arr = text.toCharArray();
        for (int i = 0; i < n / 2; ++i) {
            int count = 0;
            for (int j = 0; j + i < n; ++j) {
                int r = j + i;
                if (arr[j] == arr[r]) {
                    count++;
                    if (count == i) {
                        if (set.add(text.substring(j - i + 1, j + 1))) {
                            count--;
                        }
                    }
                } else {
                    count = 0;
                }
            }
        }
        return set.size();
    }
}
