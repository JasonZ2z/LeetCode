package com.xinzhe.contest.lccup.lc2020.group.summer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/4/25 14:56
 * Title : LCP 11. 期望个数统计
 * Description : ...
 * link : https://leetcode-cn.com/problems/qi-wang-ge-shu-tong-ji/
 * Level : Easy
 * Comment 2020-spring-group-01
 */
public class LCP_11 {
    public int expectNumber(int[] scores) {
        int n = scores.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int score : scores) {
            map.put(score, map.getOrDefault(score, 0) + 1);
        }
        return map.size();
    }

}
