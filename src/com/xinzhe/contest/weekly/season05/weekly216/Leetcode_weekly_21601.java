package com.xinzhe.contest.weekly.season05.weekly216;

/**
 * @author Xin
 * @date 2020/11/22
 * Title : 1662. 检查两个字符串数组是否相等
 * Description : 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。
 * link : https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent
 * Level : Easy
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
