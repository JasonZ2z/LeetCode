package com.xinzhe.contest.biweeekly.s1.biweekly18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/5/22
 * Title : 1331. 数组序号转换
 * Description : 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * link : https://leetcode-cn.com/problems/rank-transform-of-an-array
 * Level : Easy
 * Comment 18双周赛01
 */

public class Leetcode_biweekly_1801 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = arr.clone();
        ArrayList<Integer> list = Arrays.stream(arr).boxed().distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            map.put(list.get(i), i + 1);

        }

        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = map.get(copy[i]);
        }
        return res;
    }
}
