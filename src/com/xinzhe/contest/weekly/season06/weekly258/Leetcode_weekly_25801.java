package com.xinzhe.contest.weekly.season06.weekly258;

/**
 * @author Xin
 * @date 2021/09/12
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25801 {
    public static void main(String[] args) {
        Leetcode_weekly_25801 lc = new Leetcode_weekly_25801();

    }
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if(i == -1) return word;

        StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
        return sb.reverse().append(word.substring(i+1)).toString();
    }

}
