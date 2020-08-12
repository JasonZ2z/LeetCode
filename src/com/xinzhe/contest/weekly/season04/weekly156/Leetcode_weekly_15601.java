package com.xinzhe.contest.weekly.season04.weekly156;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/7/17
 * Title : 1207. 独一无二的出现次数
 * Description : 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * link : https://leetcode-cn.com/problems/unique-number-of-occurrences/
 * Level : Easy
 * Comment 156周赛01
 */

public class Leetcode_weekly_15601 {

    public static void main(String[] args) {
        Leetcode_weekly_15601 lc = new Leetcode_weekly_15601();
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int elem : arr) {
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        }
        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }
}
