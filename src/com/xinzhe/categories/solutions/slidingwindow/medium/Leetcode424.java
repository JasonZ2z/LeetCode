package com.xinzhe.categories.solutions.slidingwindow.medium;

/**
 * @author Xin
 * @date 2021/02/02
 * Title : 424. 替换后的最长重复字符
 * Description : 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * link ：https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * Level : medium
 */
//todo need to review
public class Leetcode424 {
    public static void main(String[] args) {
        String s = "AABABBA";
        Leetcode424 lc = new Leetcode424();
        System.out.println(lc.characterReplacement(s,1));

    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(k >= n - 1) return n;
        int l = 0, r = 0;
        int[] cnt = new int[26];
        int max = 0;
        while(r < n) {
            cnt[s.charAt(r) - 'A']++;
            max = Math.max(cnt[s.charAt(r) - 'A'], max);
            if(r - l + 1 - max > k) {
                cnt[s.charAt(l++) - 'A']--;
            }
            r++;
        }
        return r - l;
    }
}
