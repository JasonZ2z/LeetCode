package com.xinzhe.contest.weekly.season03.weekly131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/17
 * Title : 1023. 驼峰式匹配
 * Description : 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 *              给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * link : https://leetcode-cn.com/problems/camelcase-matching
 * Level : Medium
 */

public class Leetcode_weekly_13103 {
    public static void main(String[] args) {
        Leetcode_weekly_13103 lc = new Leetcode_weekly_13103();
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        char[] p = pattern.toCharArray();
        for (String query : queries) {
            if(ok(query, p)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    private boolean ok(String query, char[] p) {
        int n = p.length, i = 0;
        for (char c : query.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                if(i < n && c == p[i]) {
                    i++;
                }
            } else {
                if(i == n || c != p[i]) return false;
                else i++;
            }
        }
        return i == n;
    }
}
