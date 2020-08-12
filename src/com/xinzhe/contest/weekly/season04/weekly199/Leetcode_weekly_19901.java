package com.xinzhe.contest.weekly.season04.weekly199;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
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
        StringBuilder sb = new StringBuilder();
        for (char re : res) {
            sb.append(re);
        }
        return sb.toString();
    }
}
