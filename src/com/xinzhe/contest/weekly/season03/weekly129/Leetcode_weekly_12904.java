package com.xinzhe.contest.weekly.season03.weekly129;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1016. 子串能表示从 1 到 N 数字的二进制串
 * Description :  给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 * link : https://leetcode-cn.com/problems/binary-string-with-substrings-representing-1-to-n
 * Level : Medium
 */

public class Leetcode_weekly_12904 {
    public static void main(String[] args) {
        Leetcode_weekly_12904 lc = new Leetcode_weekly_12904();
        String s = "0110";
        System.out.println(lc.queryString(s, 3));
    }
    public boolean queryString(String S, int N) {
        if(S.length() == 1) return N == 1;
        int n = Integer.toBinaryString(N).length();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            Set<Integer> tmp = new HashSet<>();
            for (int s = 0; s+i <= S.length(); s++) {
                int j = Integer.parseInt(S.substring(s, s + i), 2);
                if(j > N) continue;
                tmp.add(j);
                if(tmp.size() == (1 << i)) break;
            }
            set.addAll(tmp);
        }
        return set.size() == N + 1;
    }

    public boolean queryString2(String S, int N) {
        return IntStream.rangeClosed(1, N).allMatch(i -> S.contains(Integer.toString(i, 2)));
    }
}
