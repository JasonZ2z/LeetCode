package com.xinzhe.contest.biweeekly.biweekly21;

/**
 * @Author Xin
 * @create 2020/5/14
 * Title : 1370. 上升下降字符串
 * Description : 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *              从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 *              从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 *              重复步骤 2 ，直到你没法从 s 中选择字符。
 *              从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 *              从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 *              重复步骤 5 ，直到你没法从 s 中选择字符。
 *              重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 *      在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *      请你返回将 s 中字符重新排序后的 结果字符串 。
 * link : https://leetcode-cn.com/problems/increasing-decreasing-string
 * Level : Easy
 * Comment 180周赛01
 */

public class Leetcode_biweekly_2101 {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }

    public static String sortString(String s) {
        int n = s.length();
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() != n) {
            for (int i = 0; i < 26; ++i) {
                if (arr[i] != 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
            for (int i = 25; i >= 0; --i) {
                if (arr[i] != 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }
}
