package com.xinzhe.contest.weekly.season05.weekly243;

/**
 * @author Xin
 * @date 2021/05/30
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24301 {
    public static void main(String[] args) {
        Leetcode_weekly_24301 lc = new Leetcode_weekly_24301();

    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();
        for (char c1 : firstWord.toCharArray()) {
            a.append(c1 - 'a');
        }
        for (char c1 : secondWord.toCharArray()) {
            b.append(c1 - 'a');
        }
        for (char c1 : targetWord.toCharArray()) {
            c.append(c1 - 'a');
        }
        return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString()) == Integer.parseInt(c.toString());
    }
}
