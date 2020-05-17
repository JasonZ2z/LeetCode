package com.xinzhe.contest.biweeekly.biweeekly26;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title :
 * Description :
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
                        BigInteger a = new BigInteger(res[i]);
                        BigInteger b = new BigInteger(s);
                        if (a.compareTo(b) < 0) {
                            res[i] = s;
                        }
                    }
                }
            }
        }
        return "".equals(res[target]) ? "0" : res[target];
    }
}
