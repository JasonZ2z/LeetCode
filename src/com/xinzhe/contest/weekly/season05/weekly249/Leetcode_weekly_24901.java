package com.xinzhe.contest.weekly.season05.weekly249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/07/11
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24901 {
    public static void main(String[] args) {
        Leetcode_weekly_24901 lc = new Leetcode_weekly_24901();
        //String s = "aabca";
        String s = "bbcbaba";
        System.out.println(lc.countPalindromicSubsequence(s));

    }
    public int countPalindromicSubsequence(String s) {
        Map<Character,  Set<Character>> map = new HashMap<>(26);
        Map<Character, List<Integer>> dict = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            dict.computeIfAbsent(s.charAt(i), a -> new ArrayList<>()).add(i);
        }
        if(dict.size() < 2) return 1;
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : dict.entrySet()) {
            char val = entry.getKey();
            if(map.get(val) != null && map.get(val).size() == 26) continue;
            List<Integer> list = entry.getValue();
            if(list.size() < 2) continue;
            if(list.size() > 2) res++;
            for (int i = 0; i+1 < list.size(); i++) {
                if(list.get(i) + 1 == list.get(i+1)) continue;
                for (int k = list.get(i) + 1; k < list.get(i+1); ++k) {
                    map.computeIfAbsent(val, a -> new HashSet<>()).add(s.charAt(k));
                }
            }
        }

        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            res += entry.getValue().size();
        }
        return res;

    }
}
