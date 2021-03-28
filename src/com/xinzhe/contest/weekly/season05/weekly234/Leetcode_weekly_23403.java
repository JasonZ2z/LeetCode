package com.xinzhe.contest.weekly.season05.weekly234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23403 {
    public static void main(String[] args) {
        Leetcode_weekly_23403 lc = new Leetcode_weekly_23403();

    }
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            if(s.charAt(i) == '(') {
                int j = i;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                String tmp = s.substring(i + 1, j);
                sb.append(map.getOrDefault(tmp, "?"));
                i = j+1;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
