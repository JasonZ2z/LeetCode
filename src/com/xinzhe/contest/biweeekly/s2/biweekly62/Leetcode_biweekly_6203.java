package com.xinzhe.contest.biweeekly.s2.biweekly62;

/**
 * @author Xin
 * @date 2021/10/02
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6203 {
    public static void main(String[] args) {
        Leetcode_biweekly_6203 lc = new Leetcode_biweekly_6203();
        System.out.println(lc.maxConsecutiveAnswers("TTFTTFTT", 1));

    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        if(k >= n/2) return n;
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    private int maxConsecutiveAnswers(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int l = 0, r = 0, count = 0, max = 0;

        while (r < n) {
            if (answerKey.charAt(r) != ch) {
                count++;
            }
            r++;

            while(count > k && l < r) {
                if (answerKey.charAt(l) != ch) {
                    count--;
                }
                l++;
            }
            max = Math.max(r - l, max);
        }
        return Math.max(max, r - l);
    }
}