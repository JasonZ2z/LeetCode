package com.xinzhe.contest.weekly.weekly174;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/5/20
 * Title : 1338. 数组大小减半
 * Description : 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * link : https://leetcode-cn.com/problems/reduce-array-size-to-the-half/
 * Level : Medium
 * Comment 174周赛02
 */

public class Leetcode_weekly_17402 {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        if (n == 1 || n == 2) return 1;
        Map<Integer, Integer> map = Arrays.stream(arr).boxed().collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        List<Integer> list = map.values().stream().sorted().collect(Collectors.toList());
        int count = 0;
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            count += list.get(i);
            res++;
            if (count >= n / 2) {
                break;
            }
        }
        return res;
    }
}
