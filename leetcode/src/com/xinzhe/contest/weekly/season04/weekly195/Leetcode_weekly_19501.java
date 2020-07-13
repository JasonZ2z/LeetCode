package com.xinzhe.contest.weekly.season04.weekly195;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/6/28
 * Title : 1496. 判断路径是否相交
 * Description : 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *              机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *              如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * link : https://leetcode-cn.com/problems/path-crossing
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
