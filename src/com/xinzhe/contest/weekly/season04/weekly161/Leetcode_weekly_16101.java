package com.xinzhe.contest.weekly.season04.weekly161;

/**
 * @author Xin
 * @date 2020/6/19
 * Title : 1247. 交换字符使得字符串相同
 * Description : 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *          每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *          交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *          最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-swaps-to-make-strings-equal/
 * Level : Medium
 * Comment 161周赛01
 */

public class Leetcode_weekly_16101 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}};
    }
    public int minimumSwap(String s1, String s2) {
        if(s1.length() != s2.length()) return -1;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if(arr1[i] != arr2[i]) {
                if(arr1[i] == 'x') count1++;
                if(arr1[i] == 'y') count2++;
            }
        }
        if(((count1 + count2) & 1) == 1)  return -1;
        return (count1+1)/2 + (count2+1)/2;

    }

}
