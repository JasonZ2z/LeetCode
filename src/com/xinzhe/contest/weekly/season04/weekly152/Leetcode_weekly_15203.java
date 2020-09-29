package com.xinzhe.contest.weekly.season04.weekly152;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 1177. 构建回文串检测
 * Description : 给你一个字符串 s，请你对 s 的子串进行检测。 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。 
 *              如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 *              返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 *              注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的
 * link : https://leetcode-cn.com/problems/can-make-palindrome-from-substring
 * Level : Medium
 */

public class Leetcode_weekly_15203 {
    public static void main(String[] args) {
        Leetcode_weekly_15203 lc = new Leetcode_weekly_15203();
    }
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        List<Boolean> res = new ArrayList<>();
        int[] dp = new int[n + 1];
        char[] arr = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] ^ (1 << (arr[i-1] - 'a'));
        }
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2];
            if(l == r || (k >= r - l - 1 && k > 0)) {
                res.add(true);
                continue;
            }
            int cur = dp[r+1] ^ dp[l];
            res.add(k >= Integer.bitCount(cur) / 2);
        }
        return res;
    }
}
