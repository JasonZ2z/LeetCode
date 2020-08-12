package com.xinzhe.contest.weekly.season04.weekly182;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/5
 * Title : 1394. 找出数组中的幸运数
 * Description : 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *              给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *      如果数组中存在多个幸运数，只需返回 最大 的那个。
 *      如果数组中不含幸运数，则返回 -1 。
 * link : https://leetcode-cn.com/problems/find-lucky-integer-in-an-array
 * Level : Easy
 */
public class Leetcode_weekly_18201 {
    public int findLucky(int[] arr) {
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey().intValue() == entry.getValue().intValue()) {
                res = Math.max(res, entry.getKey());
            }
        }
        return res;
    }
}
