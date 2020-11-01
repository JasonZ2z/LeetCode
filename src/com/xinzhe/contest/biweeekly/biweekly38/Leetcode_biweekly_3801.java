package com.xinzhe.contest.biweeekly.biweekly38;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3801 {
    public static void main(String[] args) {
        Leetcode_biweekly_3801 lc = new Leetcode_biweekly_3801();
        int[] arr = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(lc.frequencySort(arr)));
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().stream().sorted((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey() - a.getKey() : a.getValue() - b.getValue()).iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            int c = next.getValue();
            while (c-- > 0) {
                nums[i++] = next.getKey();
            }

        }
        return nums;
    }
}
