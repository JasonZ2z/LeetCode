package com.xinzhe.contest.weekly.season04.weekly199;

/**
 * @author Xin
 * @date 2020/7/25
 * Title : 1528. 重新排列字符串
 * Description : 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。返回重新排列后的字符串。
 * link : https://leetcode-cn.com/problems/shuffle-string
 * Level : Easy
 */
public class Leetcode_weekly_19901 {
    public static void main(String[] args) {
        Leetcode_weekly_19901 lc = new Leetcode_weekly_19901();
    }
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] res = new char[n];
        for (int i = 0; i < n; ++i) {
            res[indices[i]] = arr[i];
        }
        return new String(res);
    }
}
