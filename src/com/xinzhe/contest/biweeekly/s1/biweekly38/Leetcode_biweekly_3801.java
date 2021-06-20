package com.xinzhe.contest.biweeekly.s1.biweekly38;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Xin
 * @date 2020/10/31
 * Title : 1636. 按照频率将数组升序排序
 * Description : 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。请你返回排序后的数组。
 * link : https://leetcode-cn.com/problems/sort-array-by-increasing-frequency/
 * Level : Easy
 */
public class Leetcode_biweekly_3801 {
    public static void main(String[] args) {
        Leetcode_biweekly_3801 lc = new Leetcode_biweekly_3801();
        int[] arr = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(lc.frequencySort(arr)));
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] result = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(result, (a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(a) - map.get(b));
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
