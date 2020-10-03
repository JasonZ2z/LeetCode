package com.xinzhe.contest.weekly.season03.weekly148;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1147. 段式回文
 * Description : 给你一个字符串 text，在确保它满足段式回文的前提下，请你返回 段 的 最大数量 k。如果段的最大数量为 k，那么存在满足以下条件的 a_1, a_2, ..., a_k：
 *              每个 a_i 都是一个非空字符串；
 *              将这些字符串首位相连的结果 a_1 + a_2 + ... + a_k 和原始字符串 text 相同；
 *              对于所有1 <= i <= k，都有 a_i = a_{k+1 - i}。
 * link : https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition
 * Level : Hard
 */

public class Leetcode_weekly_14804 {
    public static void main(String[] args) {
        Leetcode_weekly_14804 lc = new Leetcode_weekly_14804();
        System.out.println(lc.longestDecomposition("cbabzzzzzzzcbab"));
    }
    public int longestDecomposition(String text) {
        int n = text.length();
        int ans = 0, p = 0, q = n-1, count = 0;
        while (q >= p) {
              while(p < q && text.charAt(p) != text.charAt(q)) {
                  p++;
                  count++;
              }
              if(p == q) {
                  ans++;
                  break;
              }
              String left = text.substring(p-count, p+1);
              String right = text.substring(q-count, q+1);
              if(left.equals(right)) {
                  q -= count + 1;
                  p++;
                  count = 0;
                  ans += 2;
              }else {
                  p++;
                  count++;
              }
        }
        return ans;
    }
}
