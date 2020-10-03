package com.xinzhe.contest.weekly.season04.weekly198;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/19
 * Title : 1520. 最多的不重叠子字符串
 * Description : 给你一个只包含小写字母的字符串 s ，你需要找到 s 中最多数目的非空子字符串，满足如下条件：
 *          这些字符串之间互不重叠，也就是说对于任意两个子字符串 s[i..j] 和 s[k..l] ，要么 j < k 要么 i > l 。
 *          如果一个子字符串包含字符 c ，那么 s 中所有 c 字符都应该在这个子字符串中。
 *      请你找到满足上述条件的最多子字符串数目。如果有多个解法有相同的子字符串数目，请返回这些子字符串总长度最小的一个解。可以证明最小总长度解是唯一的。请注意，你可以以 任意 顺序返回最优解的子字符串。
 * link : https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-substrings
 * Level : Medium
 */
public class Leetcode_weekly_19803 {
    public static void main(String[] args) {
        Leetcode_weekly_19803 lc = new Leetcode_weekly_19803();
        String s = "abaabbcaaabbbccd";
        System.out.println(lc.maxNumOfSubstrings(s));
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                index[i][j] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i) - 'a'][0] == -1) {
                index[s.charAt(i) - 'a'][0] = i;
            }
            index[s.charAt(i) - 'a'][1] = i;
        }
        int[] ee = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ee[i] = -1;
        }
        for (int i = 0; i < 26; i++) {
            if (index[i][0] != -1) {
                int max = index[i][1];
                for (int j = index[i][0]; j <= max; j++) {
                    if (index[s.charAt(j) - 'a'][0] >= index[i][0]) {
                        max = Math.max(max, index[s.charAt(j) - 'a'][1]);
                    } else {
                        ee[index[i][0]] = -2;
                        break;
                    }
                }
                if (ee[index[i][0]] != -2) {
                    ee[index[i][0]] = max;
                }
            }
        }
        int start = ee.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = ee.length - 1; i >= 0; i--) {
            if (ee[i] >= 0 && ee[i] < start) {
                list.add(s.substring(i, ee[i] + 1));
                start = i;
            }
        }
        return list;
    }
}
