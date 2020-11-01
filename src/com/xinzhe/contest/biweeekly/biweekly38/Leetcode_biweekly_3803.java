package com.xinzhe.contest.biweeekly.biweekly38;

/**
 * @author Xin
 * @date 2020/10/31
 * Title :
 * Description :
 * link : 
 * Level : Easy
 */
public class Leetcode_biweekly_3803 {
    public static void main(String[] args) {
        Leetcode_biweekly_3803 lc = new Leetcode_biweekly_3803();
        System.out.println(lc.countSubstrings("abe", "bbc"));
    }
    public int countSubstrings(String s, String t) {
        if(s.equals(t)) return  0;
        int m = s.length(), n = t.length();
        int res = 0;

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
