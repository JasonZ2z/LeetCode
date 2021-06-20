package com.xinzhe.contest.biweeekly.s1.biweekly26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/16
 * Title : 1449. 数位成本和为目标值的最大数字
 * Description : 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 *              给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 *              总成本必须恰好等于 target 。
 *              添加的数位中没有数字 0 。
 *              由于答案可能会很大，请你以字符串形式返回。
 *              如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * link :
 * Level : Hard
 */
public class Leetcode_biweekly_2604 {
    public static void main(String[] args) {
        int[] cost = {6, 10, 15, 40, 40, 40, 40, 40, 40};
        System.out.println(largestNumber(cost, 47));
    }

    public static String largestNumber(int[] cost, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            map.put(cost[i], i + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        String[] res = new String[50001];
        Arrays.fill(res, "");
        for (Map.Entry<Integer, Integer> entry : list) {
            res[entry.getKey()] = String.valueOf(entry.getValue());
        }
        for (int i = 1; i <= target; ++i) {
            for (Map.Entry<Integer, Integer> entry : list) {
                int c = entry.getKey();
                int index = entry.getValue();
                if (i - c > 0 && !"".equals(res[i - c])) {
                    String s = res[i - c] + index;
                    if ("".equals(res[i])) res[i] = s;
                    else {
                        res[i] = maxStr(res[i], s);
                    }
                }
            }
        }
        return "".equals(res[target]) ? "0" : res[target];
    }

    private static String maxStr(String a, String b) {
        if (a == null) return b;
        if (a.length() == b.length()) {
            return a.compareTo(b) > 0 ? a : b;
        }
        return a.length() > b.length() ? a : b;
    }
}
