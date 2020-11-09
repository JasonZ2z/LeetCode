package com.xinzhe.contest.weekly.season05.weekly214;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/11/08
 * Title : 1647. 字符频次唯一的最小删除次数
 * Description : 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 *              给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 *              字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * link : https://leetcode-cn.com/problems/minimum-deletions-to-make-character-frequencies-unique
 * Level : Medium
 */
public class Leetcode_weekly_21402 {
    public static void main(String[] args) {
        Leetcode_weekly_21402 lc = new Leetcode_weekly_21402();
        int[] arr = {3,5};
        System.out.println(lc.minDeletions("abcabc"));
    }
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i : cnt) {
            while(set.contains(i)) {
                i--;
                ans++;
            }
            if(i != 0) set.add(i);
        }
        return ans;
    }
}
