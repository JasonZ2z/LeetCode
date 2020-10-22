package com.xinzhe.categories.solutions.greedy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 763. 划分字母区间
 * Description : 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * link : https://leetcode-cn.com/problems/partition-labels/
 * Level : Medium
 */
public class Leetcode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        if(n == 1) {
            res.add(1);
            return res;
        }
        int[] dp = new int[26];
        for(int i=0; i<n; i++) dp[s.charAt(i) - 'a'] = i;

        int start = 0, end = dp[s.charAt(0) - 'a'];
        for(int i=1; i<n; i++) {
            int x = s.charAt(i) - 'a';
            if(i > end) {
                res.add(end - start + 1);
                start = i;
                end = dp[x];
            } else {
                if(dp[x] > end) {
                    end = dp[x];
                }
            }

        }
        res.add(end - start + 1);
        return res;
    }
}
