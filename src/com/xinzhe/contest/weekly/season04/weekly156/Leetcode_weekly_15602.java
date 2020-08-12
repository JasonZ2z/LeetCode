package com.xinzhe.contest.weekly.season04.weekly156;

/**
 * @author Xin
 * @date 2020/7/17
 * Title : 1208. 尽可能使字符串相等
 * Description : 给你两个长度相同的字符串，s 和 t。将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），
 *              也就是两个字符的 ASCII 码值的差的绝对值。用于变更字符串的最大预算是 maxCost。
 *              在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *              如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * link : https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 * Level : Medium
 * Comment 156周赛02
 */

public class Leetcode_weekly_15602 {

    public static void main(String[] args) {
        Leetcode_weekly_15602 lc = new Leetcode_weekly_15602();
        System.out.println(lc.equalSubstring("abcd", "acde", 0));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] dp = new int[n];
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for (int i = 0; i < n; ++i) {
            dp[i] = Math.abs(sarr[i] - tarr[i]);
        }
        int left = 0, right = 0;
        int cost = 0;
        int max = 0;
        while(right < n) {
            cost += dp[right++];
            if(cost <= maxCost) {
                max = Math.max(max, right - left);
            }
            while (left < right && cost > maxCost) {
                cost -= dp[left];
                left++;
            }
        }
        return max;
    }
}
