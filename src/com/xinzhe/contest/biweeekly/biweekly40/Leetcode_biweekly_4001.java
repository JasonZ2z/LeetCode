package com.xinzhe.contest.biweeekly.biweekly40;

/**
 * @author Xin
 * @date 2020/11/28
 * Title : 1668. 最大重复子字符串
 * Description : 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。
 *              单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
 *              给你一个字符串 sequence和 word，请你返回 最大重复值k 。
 * link : https://leetcode-cn.com/problems/maximum-repeating-substring
 * Level : Easy
 */
public class Leetcode_biweekly_4001 {
    public static void main(String[] args) {
        Leetcode_biweekly_4001 lc = new Leetcode_biweekly_4001();
        int[] arr = {2, 4, 9, 3};
        System.out.println("abc".repeat(0));
    }
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        if(!sequence.contains(word)) return 0;
        int x = 1;
        while (x * m <= n) {
            String tmp = word.repeat(x);
            if(sequence.contains(tmp)) {
                x++;
            } else {
                break;
            }
        }
        return x-1;
    }
}