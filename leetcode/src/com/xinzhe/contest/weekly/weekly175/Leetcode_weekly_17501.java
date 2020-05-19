package com.xinzhe.contest.weekly.weekly175;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/5/19
 * Title : 1346. 检查整数及其两倍数是否存在
 * Description : 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * link : https://leetcode-cn.com/problems/check-if-n-and-its-double-exist
 * Level : Easy
 * Comment 175周赛01
 */

public class Leetcode_weekly_17501 {
    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = Arrays.stream(arr).boxed().distinct().collect(Collectors.toMap(a -> 2 * a, a -> a));
        for (int i : arr) {
            if (map.containsKey(i)) {
                if (i == 0) {
                    if (Arrays.stream(arr).filter(a -> a == 0).count() >= 2) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
