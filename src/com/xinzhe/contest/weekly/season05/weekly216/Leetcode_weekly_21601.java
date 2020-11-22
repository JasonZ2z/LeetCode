package com.xinzhe.contest.weekly.season05.weekly216;

/**
 * @author Xin
 * @date 2020/11/22
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_21601 {
    public static void main(String[] args) {
        Leetcode_weekly_21601 lc = new Leetcode_weekly_21601();
        int[] arr = {3,5};
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }
        StringBuilder s2 = new StringBuilder();
        for (String s : word2) {
            s2.append(s);
        }
        return s1.toString().equals(s2.toString());
    }
}
