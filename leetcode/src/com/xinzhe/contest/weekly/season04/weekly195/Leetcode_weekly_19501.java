package com.xinzhe.contest.weekly.season04.weekly195;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/6/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 195周赛01
 */
public class Leetcode_weekly_19501 {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        int x = 0, y = 0;
        HashSet<Integer> set0 = new HashSet<>();
        set0.add(y);
        visited.put(x, set0);
        for (char c : path.toCharArray()) {
            if(c == 'N') {
                y++;
            }
            else if(c == 'S') {
                y--;
            }
            else if(c == 'E') {
                x++;
            } else {
                x--;
            }
            if(visited.containsKey(x)) {
                Set<Integer> set = visited.get(x);
                if(set.contains(y)) {
                    return true;
                }else {
                    set.add(y);
                }
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(y);
                visited.put(x, set);
            }
        }
        return false;
    }
}
