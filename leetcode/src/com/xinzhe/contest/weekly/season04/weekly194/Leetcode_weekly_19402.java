package com.xinzhe.contest.weekly.season04.weekly194;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/6/21
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 194周赛02
 */
public class Leetcode_weekly_19402 {
    public static void main(String[] args) {
        String[] arr = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        System.out.println(Arrays.toString(getFolderNames(arr)));
    }
    public static String[] getFolderNames(String[] names) {
        int n = names.length;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if(!set.contains(names[i])) {
                res[i] = names[i];
            } else {
                String prefix;
                if(map.containsKey(names[i])) {
                    prefix = names[i];
                } else {
                    if(!names[i].contains("(")) {
                        prefix = names[i];
                    } else {
                        int lastIndex = names[i].lastIndexOf("(");
                        prefix = names[i].substring(0, lastIndex);
                    }
                }
                int j = map.get(prefix);
                while (++j < n) {
                    if(j == 0) continue;
                    String tmp = names[i] + "(" + j + ")";
                    if(!set.contains(tmp)) {
                        res[i] = tmp;
                        map.put(prefix, j);
                        break;
                    }
                }
            }
            set.add(res[i]);
            map.put(res[i], -1);
        }
        return res;
    }
}
