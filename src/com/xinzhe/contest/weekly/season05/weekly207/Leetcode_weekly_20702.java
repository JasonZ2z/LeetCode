package com.xinzhe.contest.weekly.season05.weekly207;

import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/9/20
 * Title : 1593. 拆分字符串使唯一子字符串的数目最大
 * Description : 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 *              字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 *              注意：子字符串 是字符串中的一个连续字符序列。
 * link : https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 * Level : Easy
 */
public class Leetcode_weekly_20702 {
    public static void main(String[] args) {
        Leetcode_weekly_20702 lc = new Leetcode_weekly_20702();
        int[][] arr = {{0,0},{0,0},{1,0}};
        String s = "aba";
        System.out.println(lc.maxUniqueSplit(s));
    }
    int max = 0;
    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet<>());
        return max;
    }

    private void dfs(String s, int i, HashSet<String> set) {
        if(i == s.length()) {
            if(set.size() > max) {
                max = set.size();
            }
            return;
        }
        if((set.size() + s.length() - i) <= max ) return;
        for (int j = i; j < s.length(); j++) {
            for (int k = 1; j+k <= s.length(); k++) {
                String tmp = s.substring(j, j+k);
                if(set.contains(tmp)) continue;
                set.add(tmp);
                dfs(s, j+k,set);
                set.remove(tmp);
            }
        }
    }
}
