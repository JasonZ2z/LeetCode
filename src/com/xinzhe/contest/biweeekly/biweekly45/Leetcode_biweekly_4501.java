package com.xinzhe.contest.biweeekly.biweekly45;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/02/05
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4501 {
    public static void main(String[] args) {
        Leetcode_biweekly_4501 lc = new Leetcode_biweekly_4501();
        int[] arr = {2, 4, 9, 3};
    }
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) sum += entry.getKey();
        }
        return  sum;
    }
}