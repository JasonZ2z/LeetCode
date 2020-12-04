package com.xinzhe.categories.solutions.greedy.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/12/04
 * Title : 659. 分割数组为连续子序列
 * Description : 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *              如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * link : https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * Level : Medium
 */
//todo need to review
public class Leetcode659 {
    //由于需要将数组分割成一个或多个由连续整数组成的子序列，因此只要知道子序列的最后一个数字和子序列的长度，就能确定子序列。
    //贪心
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> end = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int min = nums[0], max = nums[n - 1];
        for(int i=min; i<=max; i++) {
            while (map.getOrDefault(i, 0) > 0) {
                if (end.getOrDefault(i - 1, 0) > 0) {
                    end.put(i - 1, end.get(i - 1) - 1);
                    end.put(i, end.getOrDefault(i, 0) + 1);
                    map.put(i, map.get(i) - 1);
                } else {
                    if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
                        end.put(i + 2, end.getOrDefault(i + 2, 0) + 1);
                        map.put(i, map.get(i) - 1);
                        map.put(i + 1, map.get(i + 1) - 1);
                        map.put(i + 2, map.get(i + 2) - 1);
                    } else if (map.getOrDefault(i + 1, 0) == 0 || map.getOrDefault(i + 2, 0) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //堆 + Hash
    public boolean isPossible2(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num-1)) {
                int first = map.get(num - 1).poll();
                if(map.get(num - 1).isEmpty()) map.remove(num - 1);
                map.computeIfAbsent(num, a-> new PriorityQueue<>()).add(first + 1);
            } else{
                map.computeIfAbsent(num, a-> new PriorityQueue<>()).add(1);
            }
        }
        for (PriorityQueue<Integer> value : map.values()) {
            if(value.peek() < 3) return false;
        }
        return true;
    }
}
