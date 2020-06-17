package com.xinzhe.contest.weekly.season04.weekly167;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/6/03
 * Title : 1291. 顺次数
 * Description : 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * link :  https://leetcode-cn.com/problems/sequential-digits
 * Level : Medium
 * Comment 167周赛02
 */

public class Leetcode_weekly_16702 {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(1000,
                1000000000));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        //12 23 34 45 56 67 78 89
        // 123 234 345 456 567 678 789
        // 1234 2345 3456 4567 5678 6789
        // 12345 23456

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(2, Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89));
        map.put(3, Arrays.asList(123, 234, 345, 456, 567, 678, 789));
        map.put(4, Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789));
        map.put(5, Arrays.asList(12345, 23456, 34567, 45678, 56789));
        map.put(6, Arrays.asList(123456, 234567, 345678, 456789));
        map.put(7, Arrays.asList(1234567, 2345678, 3456789));
        map.put(8, Arrays.asList(12345678, 23456789));
        map.put(9, Arrays.asList(123456789));
        map.put(10, Arrays.asList(0));
        int l = low, h = high;
        List<Integer> res = new ArrayList<>();
        int countLow = 0;
        int countHigh = 0;
        while (low > 0) {
            low /= 10;
            countLow++;
        }
        while (high > 0) {
            high /= 10;
            countHigh++;
        }
        System.out.println(countHigh);
        for (int i = countLow; i <= countHigh; ++i) {
            for (Integer j : map.get(i)) {
                if (j >= l && j <= h) {
                    res.add(j);
                }
            }
        }
        return res;

    }

}
