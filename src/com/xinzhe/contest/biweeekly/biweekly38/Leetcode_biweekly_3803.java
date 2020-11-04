package com.xinzhe.contest.biweeekly.biweekly38;

/**
 * @author Xin
 * @date 2020/10/31
 * Title : 1638. 统计只差一个字符的子串数目
 * Description : 给你两个字符串s 和t，请你找出 s中的非空子串的数目，这些子串满足替换 一个不同字符以后，是 t串的子串。换言之，请你找到 s和 t串中 恰好只有一个字符不同的子字符串对的数目。
 *              比方说，"computer" 和"computation" 加粗部分只有一个字符不同：'e'/'a'，所以这一对子字符串会给答案加 1 。请你返回满足上述条件的不同子字符串对数目。一个 子字符串是一个字符串中连续的字符。
 * link : https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character
 * Level : Medium
 */
public class Leetcode_biweekly_3803 {
    public static void main(String[] args) {
        Leetcode_biweekly_3803 lc = new Leetcode_biweekly_3803();
        System.out.println(lc.countSubstrings("abe", "bbc"));
    }
    public int countSubstrings(String s, String t) {
        if(s.equals(t)) return  0;
        int m = s.length(), n = t.length(), res = 0;
        for (char sc : s.toCharArray()) {
            for (char tc : t.toCharArray()) {
                if(sc != tc) res++;
            }
        }
        for (int len = 2; len <= m; ++len) {
            for (int i = 0; i+len <= m ; ++i) {
                for (int j = 0; j+len <= n; ++j) {
                    res += helper(s.substring(i, i+len) , t.substring(j, j+ len));
                }
            }
        }
        return res;

    }

    private int helper(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) != t.charAt(i)) count++;
            if(count > 1) return 0;
        }
        return count == 1 ? 1 : 0;
    }
}
