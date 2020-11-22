package com.xinzhe.contest.weekly.season05.weekly216;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/11/22
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_21602 {
    public static void main(String[] args) {
        Leetcode_weekly_21602 lc = new Leetcode_weekly_21602();
        int[] arr = {3,5};
        System.out.println(lc.getSmallestString(24, 552));
    }
    List<String> list = new ArrayList<>();
    String res = "";
    public String getSmallestString(int n, int k) {
        dfs(n, k, new StringBuilder());
        return res;
    }

    private boolean dfs(int n, int k, StringBuilder sb) {
        if(n == 0 && k == 0) {
            res = sb.toString();
            return true;
        }
        if(n < 0 || k < 0) return false;
        if(n * 26 < k) return false;
        for (int i = 1; i <= 26; ++i) {
            if(i <= k) {
                StringBuilder append = sb.append((char) ('a' + i - 1));
                if(dfs(n-1, k - i, append)) return true;
                append.deleteCharAt(append.length() - 1);
            }
        }
        return false;
    }
}
