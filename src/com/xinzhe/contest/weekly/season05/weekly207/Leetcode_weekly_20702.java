package com.xinzhe.contest.weekly.season05.weekly207;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/9/20
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20702 {
    public static void main(String[] args) {
        Leetcode_weekly_20702 lc = new Leetcode_weekly_20702();
        //int[][] arr = {{0,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
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
