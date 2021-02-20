package com.xinzhe.categories.structure.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/02/20
 * Title : 697. 数组的度
 * Description : 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。你的任务是在 nums 中找到与 nums拥有相同大小的度的最短连续子数组，返回其长度。
 * link : https://leetcode-cn.com/problems/degree-of-an-array
 * Level : easy
 */
public class Leetcode697 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        Leetcode697 lc = new Leetcode697();
        System.out.println(lc.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int max = 1, min = n;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int[] cur = map.get(nums[i]);
                cur[1] = i;
                cur[2]++;
                max = Math.max(max, cur[2]);
                map.put(nums[i], cur);
            } else {
                map.put(nums[i], new int[]{i,i,1});
            }
        }
        for (int[] value : map.values()) {
            if(value[2] == max) min = Math.min(min, value[1] - value[0] + 1);
        }
        return min;

    }
}
