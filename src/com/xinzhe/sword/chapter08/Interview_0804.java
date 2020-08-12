package com.xinzhe.sword.chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/7/14
 * Title : 08.04. 幂集
 * Description : 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。说明：解集不能包含重复的子集。
 * link : https://leetcode-cn.com/problems/power-set-lcci/
 * Level : Medium
 */
public class Interview_0804 {
    public static void main(String[] args) {
        Interview_0804 lc = new Interview_0804();
        int[] arr = {1,2,3};
        System.out.println(lc.subsets(arr));
    }
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        trackBack(nums, 0, new ArrayList<>());
        return list;
    }

    private void trackBack(int[] nums, int index, ArrayList<Integer> trace) {
        list.add(new ArrayList<>(trace));
        for (int i = index; i < nums.length; ++i) {
            trace.add(nums[i]);
            trackBack(nums, i+1, trace);
            trace.remove(trace.size()-1);
        }
    }
}
