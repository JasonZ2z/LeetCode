package com.xinzhe.contest.biweeekly.biweekly26;

/**
 * @author Xin
 * @date 2020/5/16
 * Title : 1446. 连续字符
 * Description : 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。请你返回字符串的能量。
 * link : https://leetcode-cn.com/problems/consecutive-characters/
 * Level : Easy
 */
public class Leetcode_biweekly_2601 {
    public int maxPower(String s) {
        int max = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n == 1) return 1;
        int cur = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (cur == arr[i]) {
                count++;
                max = Math.max(count, max);
            } else {
                cur = arr[i];
                count = 1;
            }
        }
        return max;
    }

}
